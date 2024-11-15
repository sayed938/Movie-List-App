package com.example.domain.model

data class UpcomingRootModel(
    val dates: MovieDateModel,
    val page: Long,
    val results: List<MovieModel>,
    val totalPages: Long,
    val totalResults: Long,
)
data class MovieDateModel(
    val maximum: String,
    val minimum: String,

    )
