package com.example.listmoviereal.ui.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.listmoviereal.R
import com.example.listmoviereal.data.MovieRepository
import com.example.listmoviereal.databinding.ItemMoviesBinding
import com.example.listmoviereal.domain.model.Movies
import com.example.listmoviereal.ui.viewmodel.MoviesViewModel

class MoviesViewHolder (view: View
                        ):ViewHolder(view){

    val binding=ItemMoviesBinding.bind(view)

    fun render(movies: Movies, onItemClicked: (Movies) -> Unit, onHeartIconClicked: (Movies) -> Unit) {
        binding.tvTituloMovie.text = movies.titulo
        binding.tvFechaMovie.text = movies.fecha
        binding.tvDuracionMovie.text = movies.duracion
        binding.tvGeneroMovie.text = movies.genero

        // Configurar el recurso de imagen del corazón según el estado de "corazon"
        if (!movies.corazon) {
            binding.ivcorazon.setImageResource(R.drawable.no_favorite_34)
        } else {
            binding.ivcorazon.setImageResource(R.drawable.favorite_34)
        }

        Glide.with(binding.ivMovies.context).load(movies.portada).into(binding.ivMovies)

        // Configurar el OnClickListener para el icono del corazón
        binding.ivcorazon.setOnClickListener {
            // Cambiar el estado del corazón (favorito) al hacer clic
            movies.corazon = !movies.corazon

            // Actualizar la imagen del corazón según el nuevo estado
            if (!movies.corazon) {
                binding.ivcorazon.setImageResource(R.drawable.no_favorite_34)
            } else {
                binding.ivcorazon.setImageResource(R.drawable.favorite_34)
            }

            // Llamar al onHeartIconClicked con la película actual
            onHeartIconClicked(movies)
        }

        // Configurar el OnClickListener para el elemento principal (itemView)
        itemView.setOnClickListener {
            // Llamar al onItemClicked con la película actual
            onItemClicked(movies)
        }
    }

}