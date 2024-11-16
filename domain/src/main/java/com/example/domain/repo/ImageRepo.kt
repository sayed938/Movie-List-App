package com.example.domain.repo

import com.example.domain.entity.ImagesModel

interface ImageRepo {
    suspend fun getMovieImages(movieId: String): ImagesModel
}