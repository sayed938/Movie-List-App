package com.example.data.repo

import com.example.data.utils.AppData
import com.example.data.remote.MovieService
import com.example.domain.entity.DetailsModel
import com.example.domain.entity.ImagesModel
import com.example.domain.entity.MovieRootModel
import com.example.domain.repo.DetailsRepo
import com.example.domain.repo.ImageRepo
import com.example.domain.repo.MovieRepo
import com.example.domain.repo.SearchRepo
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(private var movieService: MovieService) : MovieRepo {
    override suspend fun getMovies(category: String): MovieRootModel =
        movieService.getMovies(category, AppData.apiKey)


}

class DetailsRepoImpl @Inject constructor(private var movieService: MovieService) : DetailsRepo {
    override suspend fun getMovieDetails(movieId: String): DetailsModel =
        movieService.getDetails(movieId, AppData.apiKey)
}

class ImagedRepoImpl @Inject constructor(private var movieService: MovieService) : ImageRepo {
    override suspend fun getMovieImages(movieId: String): ImagesModel =
        movieService.getImages(movieId, AppData.apiKey)

}

class SearchRepoImpl @Inject constructor(private var movieService: MovieService) : SearchRepo {
    override suspend fun getSearchedMovie(movieKeyWord: String): MovieRootModel =
        movieService.getSearchedMovies(movieKeyWord,AppData.apiKey)

}
