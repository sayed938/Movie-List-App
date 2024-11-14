package com.example.domain.model

data class UpcomingRootModel(
    val dates: MovieDateModel,
    val page: Long,
    val results: List<MovieModel>,
    val totalPages: Long,
    val totalResults: Long,
)