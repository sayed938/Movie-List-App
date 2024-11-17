package com.example.domain.repo

import com.example.domain.entity.room_entity.LocalMoviesModel

interface LocalRepo {
    suspend fun getLocalMovies(): LocalMoviesModel
}