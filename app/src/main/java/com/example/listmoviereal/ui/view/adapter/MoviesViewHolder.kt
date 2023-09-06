package com.example.listmoviereal.ui.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.listmoviereal.R
import com.example.listmoviereal.databinding.ItemMoviesBinding
import com.example.listmoviereal.domain.model.Movies
import com.example.listmoviereal.ui.viewmodel.MoviesViewModel

class MoviesViewHolder (view: View):ViewHolder(view){

    val binding=ItemMoviesBinding.bind(view)

    fun render(movies:Movies, onClickListener:(Movies)->Unit){
        binding.tvTituloMovie.text = movies.titulo
        binding.tvFechaMovie.text = movies.fecha
        binding.tvDuracionMovie.text = movies.duracion
        binding.tvGeneroMovie.text = movies.genero

        Glide.with(binding.ivMovies.context).load(movies.portada).into(binding.ivMovies)

        itemView.setOnClickListener{ onClickListener(movies) }
    }
}