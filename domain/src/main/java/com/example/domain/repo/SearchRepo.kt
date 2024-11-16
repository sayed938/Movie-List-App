package com.example.domain.repo

import com.example.domain.entity.MovieRootModel

interface SearchRepo {
        suspend fun getSearchedMovie(movieKeyWord:String):MovieRootModel
}