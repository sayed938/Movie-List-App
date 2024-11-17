package com.example.domain.entity.room_entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movies_table")

data class LocalMoviesModel(
    @PrimaryKey val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val lastUpdated: Long
)
