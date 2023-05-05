package com.example.labo05.ui

import android.graphics.Movie
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.labo05.R
import com.example.labo05.data.Model.MovieModel
import com.example.labo05.data.Model.category
import com.example.labo05.data.Model.movies
import com.example.labo05.databinding.FragmentAddMovieBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class AddMovieFragment : Fragment() {
    private lateinit var binding: FragmentAddMovieBinding

    private val movieViewModel: MovieViewModel by viewModels(){
        MovieViewModel.Factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddMovieBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = movieViewModel
    }

    private fun observeStatus(){
        movieViewModel.status.observe(viewLifecycleOwner){status ->
            when{
                status.equals(MovieViewModel.WRONG_INFORMATION)->{
                    Log.d(APP_TAG,status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED)->{
                    Log.d(APP_TAG,status)
                    Log.d(APP_TAG,movieViewModel.getMovies().toString())
                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object{
        const val APP_TAG="APP_TAG"
    }
}