package com.example.listmoviereal.data.model

import com.google.gson.annotations.SerializedName

data class MoviesModel (@SerializedName("id") val id:Long,
                        @SerializedName("titulo") val titulo:String,
                        @SerializedName("fecha") val fecha:String,
                        @SerializedName("duracion") val duracion:String,
                        @SerializedName("genero") val genero:String,
                        @SerializedName("portada") val portada:String,
                        @SerializedName("corazon") val corazon:Boolean

                        )