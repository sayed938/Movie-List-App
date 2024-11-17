package com.example.movielistapp.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielistapp.R
import com.example.movielistapp.databinding.FragmentMainBinding
import com.example.movielistapp.ui.adapters.CategoryAdapter
import com.example.movielistapp.ui.adapters.MainMoviesAdapter
import com.example.movielistapp.ui.adapters.OnItemClickListener
import com.example.movielistapp.ui.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

import kotlinx.coroutines.launch

@Suppress("ControlFlowWithEmptyBody", "UNUSED_EXPRESSION")
@AndroidEntryPoint
class MainFragment :
    Fragment(R.layout.fragment_main), OnItemClickListener {
    private lateinit var binding: FragmentMainBinding
    private lateinit var category: String
    private val movieModel: MoviesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.categoryRecycler.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        binding.mainRecycler.layoutManager =
            GridLayoutManager(view.context, 2)
        binding.categoryRecycler.adapter = CategoryAdapter(this)

        binding.searchIcon.setOnClickListener {
            navigateToSearch()
        }
        lifecycleScope.launch {
            movieModel.popularMovies.collect {
                if (it == null) {
                    delay(1000)
                } else {
                    binding.mainRecycler.adapter =
                        MainMoviesAdapter(it.results, 0)
                    MainMoviesAdapter(it.results, 0).notifyDataSetChanged()
                }

            }
        }
    }

    private fun navigateToSearch() {
        findNavController().navigate(R.id.action_mainFragment_to_searchFragment)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onItemClick(movie: String) {

        lifecycleScope.launch {
            when (movie) {
                "Popular" -> {
                    movieModel.popularMovies.collect {
                        try {
                            binding.mainRecycler.adapter =
                                MainMoviesAdapter(it!!.results, 0)

                        } catch (e: Exception) {
                            delay(1000)
                        }

                    }
                }

                "Top Rated" -> {
                    movieModel.topRatedMovies.collect {
                        try {
                            binding.mainRecycler.adapter =
                                MainMoviesAdapter(it!!.results, 0)

                        } catch (e: Exception) {
                            delay(1000)
                        }

                    }
                }

                "Now Playing" -> {
                    lifecycleScope.launch {
                        movieModel.nowPlayingMovies.collect {
                            try {
                                binding.mainRecycler.adapter =
                                    MainMoviesAdapter(it!!.results, 0)

                            } catch (e: Exception) {
                                delay(1000)
                            }
                        }
                    }
                }

                "Upcoming" -> {
                    lifecycleScope.launch {
                        movieModel.upcomingMovies.collect {
                            try {
                                binding.mainRecycler.adapter =
                                    MainMoviesAdapter(it!!.results, 0)

                            } catch (e: Exception) {
                                delay(1000)
                            }

                        }
                    }
                }
            }
        }
    }
}