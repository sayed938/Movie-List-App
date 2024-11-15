package com.example.domain.usecase.toprated_usecase

import com.example.domain.entity.MovieRootModel

interface TopRatedUseCaseRepo {
    fun getTopRatedMovies(topRated: String): MovieRootModel
}