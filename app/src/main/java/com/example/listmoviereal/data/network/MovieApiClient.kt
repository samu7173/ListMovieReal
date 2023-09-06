package com.example.listmoviereal.data.network


import com.example.listmoviereal.data.model.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiClient {
    @GET("movies")
    suspend fun getAllQuotes():Response<List<MoviesModel>>
}