package com.example.domain.repo

import com.example.domain.entity.DetailsModel

interface DetailsRepo {
    suspend fun getMovieDetails(movieId:String): DetailsModel
}