package com.example.labo05.ui.movie.bilboard.recyclerview

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.labo05.data.Model.MovieModel
import com.example.labo05.databinding.MovieItemBinding

class MovieRecyclerViewAdapter(
    private val clickListener:(MovieModel)->Unit
):RecyclerView.Adapter<MovieRecyclerViewHolder> (){
    private val movies = ArrayList<MovieModel>()

    fun setData(movieList: List<MovieModel>){
        movies.clear()
        movies.addAll(movieList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie,clickListener)
    }
}