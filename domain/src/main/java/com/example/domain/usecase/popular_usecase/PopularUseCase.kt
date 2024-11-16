package com.example.domain.usecase.popular_usecase

import com.example.domain.entity.MovieRootModel
import com.example.domain.repo.MovieRepo
import javax.inject.Inject

class PopularUseCase @Inject constructor(private var popularMovie: MovieRepo) : PopularUseCaseRepo {
    override suspend fun getPopularMovies(popular: String): MovieRootModel =
        popularMovie.getMovies(popular)
}