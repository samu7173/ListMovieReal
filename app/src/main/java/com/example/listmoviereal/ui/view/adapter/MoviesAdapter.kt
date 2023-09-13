package com.example.listmoviereal.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listmoviereal.R
import com.example.listmoviereal.domain.model.Movies
import com.example.listmoviereal.ui.viewmodel.MoviesViewModel

class MoviesAdapter(
    var moviesList: List<Movies>,
    private val onItemClicked: (Movies) -> Unit,
    private val onHeartIconClicked: (Movies, Long,Boolean) -> Unit
)  : RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_movies, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = moviesList[position]
        // Supongamos que tienes un ID único asociado a cada película (movieId)
        val movieId = item.id // Aquí debes obtener el movieId correspondiente
        val movieFavorite=item.corazon
        holder.render(item, onItemClicked, { movie -> onHeartIconClicked(movie, movieId,movieFavorite) })
    }

    fun updateMovies(movies: List<Movies>) {
        this.moviesList = movies
        notifyDataSetChanged()
    }
}

