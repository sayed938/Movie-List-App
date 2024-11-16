package com.example.domain.usecase.toprated_usecase

import com.example.domain.entity.MovieRootModel

interface TopRatedUseCaseRepo {
   suspend fun getTopRatedMovies(topRated: String): MovieRootModel
}