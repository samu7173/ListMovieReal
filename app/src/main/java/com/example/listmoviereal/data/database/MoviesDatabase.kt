package com.example.listmoviereal.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.listmoviereal.data.database.dao.MoviesDao
import com.example.listmoviereal.data.database.entities.MoviesEntity


@Database(entities = [MoviesEntity::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun getQuoteDao(): MoviesDao
}
