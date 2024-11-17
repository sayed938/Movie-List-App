package com.example.data.remote

import android.media.Image
import com.example.domain.entity.DetailsModel
import com.example.domain.entity.ImagesModel
import com.example.domain.entity.MovieRootModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/{sort}")
    suspend fun getMovies(
        @Path("sort") sort: String,
        @Query("api_key") apiKey: String
    ):MovieRootModel

    @GET("movie/{sort}")
    suspend fun getDetails(
        @Path("sort") sort: String,
        @Query("api_key") apiKey: String
    ):DetailsModel

    @GET("movie/{sort}/images")
    suspend fun getImages(
        @Path("sort") sort: String,
        @Query("api_key") apiKey: String
    ):ImagesModel

    @GET("discover/movie")
    suspend fun getSearchedMovies(
        @Query("with_keywords") withKeywords: String,
        @Query("api_key") apiKey: String
    ):MovieRootModel
}