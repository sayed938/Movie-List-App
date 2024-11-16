package com.example.domain.usecase.toprated_usecase

import com.example.domain.entity.MovieRootModel
import com.example.domain.repo.MovieRepo
import javax.inject.Inject


class TopRatedUseCase @Inject constructor(private var topRatedMovies: MovieRepo) :
    TopRatedUseCaseRepo {
    override suspend fun getTopRatedMovies(topRated: String): MovieRootModel =
        topRatedMovies.getMovies(topRated)

}
