package com.example.movielistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.DetailsModel
import com.example.domain.entity.ImagesModel
import com.example.domain.entity.MovieRootModel
import com.example.domain.usecase.details_usecase.DetailsUseCase
import com.example.domain.usecase.details_usecase.image_usecase.ImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private var detailsUseCase: DetailsUseCase,
    private var imagesUseCase: ImageUseCase
) :
    ViewModel() {


    private val _movieDetails: MutableStateFlow<DetailsModel?> = MutableStateFlow(null)
    val movieDetails: StateFlow<DetailsModel?> = _movieDetails
    private val _movieImages: MutableStateFlow<ImagesModel?> = MutableStateFlow(null)
    val movieImages: StateFlow<ImagesModel?> = _movieImages

    fun getMovieDetails(movieId: String) {
        viewModelScope.launch {
            _movieDetails.value = detailsUseCase.getMoviesDetails(movieId)
        }
    }

    fun getMovieImages(movieId: String) {
        viewModelScope.launch {
            _movieImages.value = imagesUseCase.getImages(movieId)
        }
    }
}