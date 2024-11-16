package com.example.movielistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.MovieRootModel
import com.example.domain.usecase.search_usecase.SearchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(private var searchUseCase: SearchUseCase) : ViewModel() {

    private val _searchedMovies: MutableStateFlow<MovieRootModel?> = MutableStateFlow(null)
    val searchedMovies: StateFlow<MovieRootModel?> = _searchedMovies

    fun getSearchedMovies(movieKeyWord: String) {
        viewModelScope.launch {
            _searchedMovies.value = searchUseCase.getSearchedMovies(movieKeyWord)
        }
    }
}