package com.example.domain.usecase.details_usecase.image_usecase

import com.example.domain.entity.ImagesModel

interface ImageUseCaseRepo {
    suspend fun getImages(movieId:String):ImagesModel
}