package com.example.domain.usecase.upcoming_usecase

import com.example.domain.entity.MovieRootModel
import com.example.domain.repo.MovieRepo
import javax.inject.Inject

class UpcomingUseCase @Inject constructor(private var upcomingMovies: MovieRepo) :
    UpcomingUseCaseRepo {
    override suspend fun getUpcomingMovies(upcoming: String): MovieRootModel =
        upcomingMovies.getMovies(upcoming)
}