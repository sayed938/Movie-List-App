package com.example.domain.entity

data class MovieRootModel(
    var page: Int,
    var results: ArrayList<MovieModel>,
    var total_pages: Int,
    var total_results: Int
)

data class MovieModel(
    var dult: Boolean,
    var backdrop_path: String,
    var genre_ids: ArrayList<Int>,
    var id: Int,
    var original_language: String,
    var original_title: String,
    var overview: String,
    var popularity: Double,
    var poster_path: String,
    var release_date: String,
    var title: String,
    var video: Boolean,
    var vote_average: Double,
    var vote_count: Int
)