package com.example.domain.entity

data class ImagesModel(
    val backdrops: List<Backdrop>,
    val id: Long,
    val logos: List<Logo>,
    val posters: List<Poster>
)

data class Backdrop(
    val aspect_ratio: Double,
    val height: Long,
    val iso_639_1: String?,
    val file_path: String,
    val vote_average: Double,
    val vote_count: Long,
    val width: Long,
)

data class Logo(
    val aspect_ratio: Double,
    val height: Long,
    val iso_639_1: String,
    val file_path: String,
    val vote_average: Double,
    val vote_count: Long,
    val width: Long,
)

data class Poster(
    val aspect_ratio: Double,
    val height: Long,
    val iso_639_1: String?,
    val file_path: String,
    val vote_average: Double,
    val vote_count: Long,
    val width: Long,
)