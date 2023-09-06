package com.example.listmoviereal.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.listmoviereal.databinding.ActivityDescriptionBinding
import com.example.listmoviereal.domain.model.Movies


class DescriptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeMovieData()
        val imageViewBackArrow = binding.imageViewBackArrow
        imageViewBackArrow.setOnClickListener {
            onBackPressed() // Esta línea ejecutará la acción de retroceso
        }

    }

    private fun observeMovieData() {
        val intent = intent
        val movies = intent.getParcelableExtra<Movies>("movies")
        if (movies != null) {
            // Realiza las acciones necesarias con el objeto Movies
            Glide.with(binding.imageViewPoster.context).load(movies.portada).into(binding.imageViewPoster)
            binding.textViewTitulo.text = movies.titulo
            binding.textViewFecha.text = movies.fecha
            binding.textViewDuracion.text = movies.duracion
            binding.textViewGenero.text = movies.genero


            Toast.makeText(this, movies.titulo, Toast.LENGTH_SHORT).show()
        }
    }
}