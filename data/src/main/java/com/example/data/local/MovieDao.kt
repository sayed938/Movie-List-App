package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.domain.entity.room_entity.LocalMoviesModel

@Dao
interface MovieDao {

    /*@Insert
    suspend fun insertAll(movies: List<LocalMoviesModel>)

    @Query("SELECT * FROM movies_table")
    suspend fun getAllMovies(): List<LocalMoviesModel>

    @Query("SELECT * FROM movies_table WHERE lastUpdated > :timeLimit")
    suspend fun getMoviesIfNotExpired(timeLimit: Long): List<LocalMoviesModel>

    @Query("UPDATE movies_table SET lastUpdated = :timestamp")
    suspend fun updateLastUpdated(timestamp: Long)*/
}