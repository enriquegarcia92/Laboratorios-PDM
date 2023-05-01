package com.example.labo05.ui

import android.graphics.Movie
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.labo05.R
import com.example.labo05.data.Model.MovieModel
import com.example.labo05.data.Model.category
import com.example.labo05.data.Model.movies
import kotlinx.coroutines.NonDisposableHandle.parent

class AddMovieFragment : Fragment() {
    private lateinit var nameEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var descEditText: EditText
    private lateinit var scoreEditText: EditText
    private lateinit var submittbutton: Button

    private val viewModel: MovieViewModel by viewModels(){
        MovieViewModel.Factory
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun bind(view: View){
        nameEditText = view.findViewById(R.id.name_edit_text)
        categoryEditText = view.findViewById(R.id.category_edit_text)
        descEditText = view.findViewById(R.id.desc_edit_text)
        scoreEditText = view.findViewById(R.id.score_edit_text)
        submittbutton = view.findViewById(R.id.submit_button)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_movie, container, false)
    }

    private fun setListeners(){
        submittbutton.setOnClickListener {
            var newMovie = MovieModel(nameEditText.text.toString(),categoryEditText.text.toString(),
                descEditText.text.toString(),scoreEditText.text.toString())
            viewModel.addMovies(newMovie)
            var toshowmovies = viewModel.getMovies()
            var showlength= toshowmovies.size
            System.out.println(toshowmovies)
            Toast.makeText(getActivity(), toshowmovies[showlength-1].name +" "+ toshowmovies[showlength-1].category +" "+ toshowmovies[showlength-1].description +" "+toshowmovies[showlength-1].qualification , Toast.LENGTH_SHORT).show();
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        setListeners()
    }
}