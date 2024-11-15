package com.example.domain.repo

import com.example.domain.model.MovieRootModel

interface MovieRepo {
    fun getMovies(category:String):MovieRootModel
}