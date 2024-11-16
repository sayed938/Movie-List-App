package com.example.domain.usecase.nowplaying_usecase

import com.example.domain.entity.MovieRootModel

interface NowPlayingUseCaseRepo {
    suspend fun getNowPlayingMovies(nowPlaying: String): MovieRootModel
}