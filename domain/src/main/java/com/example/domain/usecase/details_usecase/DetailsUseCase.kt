package com.example.domain.usecase.details_usecase

import com.example.domain.entity.DetailsModel
import com.example.domain.repo.DetailsRepo
import javax.inject.Inject

class DetailsUseCase @Inject constructor(private var detailsRepo: DetailsRepo) :
    DetailsUSeCaseRepo {
    override suspend fun getMoviesDetails(movieId: String): DetailsModel =
        detailsRepo.getMovieDetails(movieId)
}