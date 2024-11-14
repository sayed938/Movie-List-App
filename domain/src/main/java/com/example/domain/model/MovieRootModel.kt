package com.example.domain.model

data class MovieRootModel (
    val page: Long,
    val results: List<MovieModel>,
    val totalPages: Long,
    val totalResults: Long,
)