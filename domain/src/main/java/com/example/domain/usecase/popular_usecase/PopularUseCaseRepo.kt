package com.example.domain.usecase.popular_usecase

import com.example.domain.entity.MovieRootModel

interface PopularUseCaseRepo {
    suspend fun getPopularMovies(popular: String): MovieRootModel
}