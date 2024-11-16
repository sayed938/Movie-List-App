package com.example.domain.usecase.search_usecase

import com.example.domain.entity.MovieRootModel

interface SearchUseCaseRepo {
    suspend fun getSearchedMovies(movieKeyWord: String): MovieRootModel
}