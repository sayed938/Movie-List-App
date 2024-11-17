package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.domain.entity.room_entity.LocalMoviesModel

@Database(entities = [LocalMoviesModel::class], version = 1, exportSchema = false)

abstract class MovieDataBase():RoomDatabase() {
    abstract fun movieDao(): MovieDao
    companion object {
        private var instance: MovieDataBase? = null

        @Synchronized
        fun getInstance(context: Context): MovieDataBase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    MovieDataBase::class.java, "instance_data"
                )
                    .fallbackToDestructiveMigration().build()
            }
            return instance
        }

    }
}