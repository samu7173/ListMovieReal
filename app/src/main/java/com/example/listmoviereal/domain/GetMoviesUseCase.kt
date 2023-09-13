package com.example.listmoviereal.domain

import com.example.listmoviereal.data.MovieRepository
import com.example.listmoviereal.data.database.entities.toDatabase
import com.example.listmoviereal.data.preference.AppPreferences
import com.example.listmoviereal.domain.model.Movies
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository,
    private val appPreferences: AppPreferences // Inyecta AppPreferences
) {

    suspend operator fun invoke(): List<Movies> {
        if (appPreferences.hasDataDownloaded()) {
            // Los datos ya se han descargado previamente, obtén los datos de la base de datos local
            return repository.getAllQuotesFromDatabase()
        } else {
            // Los datos aún no se han descargado, obtén los datos de la API
            val quote = repository.getAllQuotesFromApi()
            if (quote.isNotEmpty()) {
                repository.clearQuotes()
                repository.insertQuotes(quote.map { it.toDatabase() })
                appPreferences.setDataDownloaded(true) // Marca los datos como descargados
            }
            return quote
        }
    }
}
