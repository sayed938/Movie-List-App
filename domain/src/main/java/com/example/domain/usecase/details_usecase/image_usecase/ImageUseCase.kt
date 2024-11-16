package com.example.domain.usecase.details_usecase.image_usecase

import com.example.domain.entity.ImagesModel
import com.example.domain.repo.DetailsRepo
import com.example.domain.repo.ImageRepo
import javax.inject.Inject

class ImageUseCase @Inject constructor(private var imageRepo: ImageRepo) : ImageUseCaseRepo {
    override suspend fun getImages(movieId: String): ImagesModel = imageRepo.getMovieImages(movieId)
}