package com.example.movielistapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.MovieRootModel
import com.example.domain.usecase.search_usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SearchViewModel @Inject constructor(private var searchUseCase: SearchUseCase) : ViewModel() {

    private val _searchedMovies: MutableStateFlow<MovieRootModel?> = MutableStateFlow(null)
    val searchedMovies: StateFlow<MovieRootModel?> = _searchedMovies

    fun getSearchedMovies(movieKeyWord: String) {
        viewModelScope.launch {
            try {
                _searchedMovies.value = searchUseCase.getSearchedMovies(movieKeyWord)

            }
            catch (e:Exception){
                Log.d("sayedModel",e.message.toString())
            }
        }
    }
}