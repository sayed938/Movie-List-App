package com.example.movielistapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.MovieModel
import com.example.domain.entity.MovieRootModel
import com.example.domain.usecase.nowplaying_usecase.NowPlayingUseCase
import com.example.domain.usecase.popular_usecase.PopularUseCase
import com.example.domain.usecase.toprated_usecase.TopRatedUseCase
import com.example.domain.usecase.upcoming_usecase.UpcomingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private var popular: PopularUseCase,
    private var topRated: TopRatedUseCase,
    private var nowPlaying: NowPlayingUseCase,
    private var upcoming: UpcomingUseCase
) : ViewModel() {
    init {
        getPopular()
        getTopRated()
        getNowPlaying()
        getUpcoming()
    }

    private val _popularMovies: MutableStateFlow<MovieRootModel?> = MutableStateFlow(null)
    val popularMovies: StateFlow<MovieRootModel?> = _popularMovies
    private val _topRatedMovies: MutableStateFlow<MovieRootModel?> = MutableStateFlow(null)
    val topRatedMovies: StateFlow<MovieRootModel?> = _topRatedMovies
    private val _nowPlayingMovies: MutableStateFlow<MovieRootModel?> = MutableStateFlow(null)
    val nowPlayingMovies: StateFlow<MovieRootModel?> = _nowPlayingMovies
    private val _upcomingMovies: MutableStateFlow<MovieRootModel?> = MutableStateFlow(null)
    val upcomingMovies: StateFlow<MovieRootModel?> = _upcomingMovies

    private fun getPopular() {
        viewModelScope.launch {
            try {
                _popularMovies.value = popular.getPopularMovies("popular")

            } catch (e: Exception) {
                Log.d("sayedMovie", e.message.toString())
            }
        }
    }

    private fun getTopRated() {
        viewModelScope.launch {
            try {
                _topRatedMovies.value = topRated.getTopRatedMovies("top_rated")

            } catch (e: Exception) {
                Log.d("sayedMovie", e.message.toString())
            }
        }
    }

    private fun getNowPlaying() {
        viewModelScope.launch {
            try {
                _nowPlayingMovies.value = nowPlaying.getNowPlayingMovies("now_playing")

            } catch (e: Exception) {
                Log.d("sayedMovie", e.message.toString())
            }
        }
    }

    private fun getUpcoming() {
        viewModelScope.launch {
            try {
                _upcomingMovies.value = upcoming.getUpcomingMovies("upcoming")

            } catch (e: Exception) {
                Log.d("sayedMovie", e.message.toString())
            }
        }
    }
}