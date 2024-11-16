package com.example.domain.usecase.nowplaying_usecase

import com.example.domain.entity.MovieRootModel
import com.example.domain.repo.MovieRepo
import javax.inject.Inject

class NowPlayingUseCase @Inject constructor(private var nowPlayingMovies: MovieRepo) :
    NowPlayingUseCaseRepo {
    override suspend fun getNowPlayingMovies(nowPlaying: String): MovieRootModel =
        nowPlayingMovies.getMovies(nowPlaying)
}