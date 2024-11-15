package com.example.movielistapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movielistapp.R
import com.example.movielistapp.databinding.FragmentMainBinding
import com.example.movielistapp.ui.adapters.CategoryAdapter
import com.example.movielistapp.ui.adapters.MainMoviesAdapter

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMainBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.categoryRecycler.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        binding.mainRecycler.layoutManager =
            GridLayoutManager(view.context, 2)
        binding.categoryRecycler.adapter = CategoryAdapter()
        binding.mainRecycler.adapter = MainMoviesAdapter()
        binding.searchIcon.setOnClickListener {
            navigateToSearch()
        }
    }

    private fun navigateToSearch() {
        findNavController().navigate(R.id.action_mainFragment_to_searchFragment)
    }
}