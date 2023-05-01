package com.example.labo05.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.labo05.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MoviesFragment : Fragment() {

    private lateinit var buttonMovie: FloatingActionButton
    private lateinit var cardStarWars: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        buttonMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_moviesFragment_to_addMovieFragment)
        }
        cardStarWars.setOnClickListener {
            it.findNavController().navigate(R.id.action_moviesFragment_to_movieFragment)
        }
    }

    private fun bind(){
        buttonMovie = view?.findViewById(R.id.addButton) as FloatingActionButton
        cardStarWars = view?.findViewById(R.id.first_card_view) as CardView

    }
}