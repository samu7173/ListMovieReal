package com.example.listmoviereal.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.listmoviereal.domain.model.Movies


@Entity(tableName = "movie_table")
data class MoviesEntity (
    @PrimaryKey()
    @ColumnInfo(name="id") val id:Long,
    @ColumnInfo(name="titulo") val titulo:String,
    @ColumnInfo(name="fecha") val fecha:String,
    @ColumnInfo(name="duracion") val duracion:String,
    @ColumnInfo(name="genero") val genero:String,
    @ColumnInfo(name="portada") val portada:String,
    @ColumnInfo(name="corazon") val corazon:Boolean
    )

fun Movies.toDatabase() = MoviesEntity(id=id,titulo = titulo, fecha = fecha, duracion = duracion, genero = genero, portada =portada, corazon = corazon )