package com.example.data.repo

import com.example.data.utils.AppData
import com.example.data.remote.MovieService
import com.example.domain.entity.MovieRootModel
import com.example.domain.repo.MovieRepo
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(private var movieService: MovieService) : MovieRepo {
    override suspend fun getMovies(category: String): MovieRootModel =
        movieService.getMovies(category, AppData.apiKey)
}