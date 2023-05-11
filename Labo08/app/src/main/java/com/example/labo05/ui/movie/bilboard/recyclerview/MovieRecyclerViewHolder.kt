package com.example.labo05.ui.movie.bilboard.recyclerview

import android.graphics.Movie
import androidx.recyclerview.widget.RecyclerView
import com.example.labo05.data.Model.MovieModel
import com.example.labo05.databinding.MovieItemBinding
import com.example.labo05.generated.callback.OnClickListener

class MovieRecyclerViewHolder(private val binding: MovieItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(movie:MovieModel,clickListener: (MovieModel)->Unit){
        binding.movieNameText.text = movie.name
        binding.gradeTextView.text = movie.qualification

        binding.firstCardView.setOnClickListener{
            clickListener(movie)
        }
    }
}