package com.example.listmoviereal.data.network

import com.example.listmoviereal.data.model.MoviesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val api: MovieApiClient){

    suspend fun getQuotes():List<MoviesModel>{
        return withContext(Dispatchers.IO){
            val response=api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}