package com.example.domain.usecase.upcoming_usecase

import com.example.domain.entity.MovieRootModel

interface UpcomingUseCaseRepo {
    suspend fun getUpcomingMovies(upcoming: String): MovieRootModel
}