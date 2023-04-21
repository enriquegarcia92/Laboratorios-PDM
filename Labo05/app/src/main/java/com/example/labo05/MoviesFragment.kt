package com.example.labo05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MoviesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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