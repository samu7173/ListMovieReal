package com.example.listmoviereal.data

import com.example.listmoviereal.data.database.dao.MoviesDao
import com.example.listmoviereal.data.database.entities.MoviesEntity
import com.example.listmoviereal.data.network.MovieService
import com.example.listmoviereal.domain.model.Movies
import com.example.listmoviereal.domain.model.toDomain
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private var api:MovieService,
    private val quoteDao:MoviesDao
    ) {

    suspend fun getAllQuotesFromApi():List<Movies>{
        val response=api.getQuotes()

        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Movies>{
        val response=quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<MoviesEntity>) {
        quoteDao.insertAll(quotes)
    }
    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }

}