package com.example.data.remote

import com.example.domain.entity.MovieRootModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("/{sort}")
    fun getMovies(
        @Path("sort") sort: String,
        @Query("api_key") apiKey: String
    ):MovieRootModel
}