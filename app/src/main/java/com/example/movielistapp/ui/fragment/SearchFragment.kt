package com.example.movielistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movielistapp.R
import com.example.movielistapp.databinding.FragmentMainBinding
import com.example.movielistapp.databinding.FragmentSearchBinding
import com.example.movielistapp.ui.adapters.MainMoviesAdapter
import com.example.movielistapp.ui.viewmodel.MoviesViewModel
import com.example.movielistapp.ui.viewmodel.SearchViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val searchModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchView.clearFocus()
        binding.searchRecycler.layoutManager =
            GridLayoutManager(view.context, 2)
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.progressBar2.visibility = View.VISIBLE
                searchModel.getSearchedMovies(query.toString())
                getSearchedMovies()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                binding.progressBar2.visibility = View.VISIBLE
                searchModel.getSearchedMovies(newText.toString())
                getSearchedMovies()
                return true
            }


        })
    }

    fun getSearchedMovies() {
        lifecycleScope.launch {
            searchModel.searchedMovies.collect {
                withContext(Dispatchers.Main) {
                    try {
                        binding.searchRecycler.adapter = MainMoviesAdapter(it!!.results, 1)
                        binding.progressBar2.visibility = View.INVISIBLE
                    } catch (e: Exception) {
                        delay(5000)
                        binding.progressBar2.visibility = View.INVISIBLE
                    }

                }

            }

        }
    }
}
