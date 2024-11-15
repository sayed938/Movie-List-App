package com.example.domain.repo

import com.example.domain.entity.MovieRootModel

interface MovieRepo {
    fun getMovies(category:String):MovieRootModel
}
