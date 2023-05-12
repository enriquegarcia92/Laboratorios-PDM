package com.example.labo05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.labo05.R
import com.example.labo05.databinding.FragmentAddMovieBinding
import com.example.labo05.databinding.FragmentMovieBinding
import com.example.labo05.ui.movie.viewmodel.MovieViewModel

class MovieFragment : Fragment() {
    private lateinit var binding: FragmentMovieBinding

    private val movieViewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = movieViewModel
    }
}