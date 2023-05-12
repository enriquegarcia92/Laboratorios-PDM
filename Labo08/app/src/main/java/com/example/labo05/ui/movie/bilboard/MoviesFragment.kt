package com.example.labo05.ui.movie.bilboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labo05.R
import com.example.labo05.data.Model.MovieModel
import com.example.labo05.databinding.FragmentMovieBinding
import com.example.labo05.databinding.FragmentMoviesBinding
import com.example.labo05.ui.movie.bilboard.recyclerview.MovieRecyclerViewAdapter
import com.example.labo05.ui.movie.viewmodel.MovieViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MoviesFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentMoviesBinding
    private lateinit var adapter: MovieRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)
        binding.addButton.setOnClickListener{
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_moviesFragment_to_addMovieFragment)
        }
    }

    private fun showSelectedMovie(movie:MovieModel){
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_moviesFragment_to_movieFragment)
    }

    private fun displayMovies(){
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view:View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie->
            showSelectedMovie(selectedMovie)
        }
        binding.recyclerView.adapter=adapter
        displayMovies()
    }


}