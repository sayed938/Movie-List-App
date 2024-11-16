package com.example.domain.usecase.details_usecase

import com.example.domain.entity.DetailsModel
import com.example.domain.entity.MovieRootModel

interface DetailsUSeCaseRepo {
    suspend fun getMoviesDetails(movieId: String): DetailsModel

}