package com.example.listmoviereal.domain

import com.example.listmoviereal.data.MovieRepository
import com.example.listmoviereal.data.database.entities.toDatabase
import com.example.listmoviereal.domain.model.Movies
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private var repository : MovieRepository){

    suspend operator fun invoke():List<Movies> {
        val quote = repository.getAllQuotesFromApi()
        return if(quote.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quote.map { it.toDatabase() })
            quote
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }

}