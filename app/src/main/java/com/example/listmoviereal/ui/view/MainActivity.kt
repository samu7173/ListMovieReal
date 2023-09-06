package com.example.listmoviereal.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listmoviereal.databinding.ActivityMainBinding
import com.example.listmoviereal.domain.model.Movies
import com.example.listmoviereal.ui.view.adapter.MoviesAdapter
import com.example.listmoviereal.ui.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val moviesViewModel: MoviesViewModel by viewModels()
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        observeMovieData()

        moviesViewModel.onCreate()

        setupSearchView()
    }

    private fun initRecyclerView() {
        moviesAdapter = MoviesAdapter(emptyList()) { onItemSelected(it) }
        binding.recyclerMovies.layoutManager = LinearLayoutManager(this)
        binding.recyclerMovies.adapter = moviesAdapter
    }

    private fun observeMovieData() {
        moviesViewModel.moviesLiveData.observe(this) { movies ->
            if (movies != null && movies.isNotEmpty()) {
                moviesAdapter.updateMovies(movies)
            }
        }
    }

    private fun setupSearchView() {
        binding.searchMovies.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                moviesAdapter.updateMovies(moviesViewModel.filterMoviesByTitle(newText))
                return true
            }
        })
    }

    fun onItemSelected(movies:Movies){
        val intent = Intent(this, DescriptionActivity::class.java)
        intent.putExtra("movies", movies)
        startActivity(intent)
    }
}

