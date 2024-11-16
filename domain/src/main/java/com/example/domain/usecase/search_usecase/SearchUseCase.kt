package com.example.domain.usecase.search_usecase

import com.example.domain.entity.MovieRootModel
import com.example.domain.repo.MovieRepo
import com.example.domain.repo.SearchRepo
import com.example.domain.usecase.popular_usecase.PopularUseCaseRepo
import javax.inject.Inject

class SearchUseCase @Inject constructor(private var searchedMovie: SearchRepo) : SearchUseCaseRepo {
    override suspend fun getSearchedMovies(movieKeyWord: String): MovieRootModel =
        searchedMovie.getSearchedMovie(movieKeyWord)

}