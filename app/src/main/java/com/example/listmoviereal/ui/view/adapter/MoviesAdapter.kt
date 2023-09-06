package com.example.listmoviereal.ui.view.adapter

import android.annotation.SuppressLint
import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listmoviereal.R
import com.example.listmoviereal.domain.model.Movies

class MoviesAdapter(var moviesList: List<Movies>, private val onClickListener:(Movies)->Unit) : RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_movies, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int = moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = moviesList[position]
        holder.render(item,onClickListener)
    }

    fun updateMovies(movies: List<Movies>) {
        this.moviesList = movies
        notifyDataSetChanged()
    }
}
