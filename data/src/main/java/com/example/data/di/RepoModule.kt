package com.example.data.di

import com.example.data.remote.MovieService
import com.example.data.repo.MovieRepoImpl
import com.example.domain.repo.MovieRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideMovieRepo(movieService:MovieService):MovieRepo{
        return MovieRepoImpl(movieService)
    }
}