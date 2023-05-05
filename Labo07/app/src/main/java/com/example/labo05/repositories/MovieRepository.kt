package com.example.labo05.repositories

import com.example.labo05.data.Model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {
    fun getMovies() = movies
    fun addMovies(movie:MovieModel) {
        movies.add(movie)
    }
}