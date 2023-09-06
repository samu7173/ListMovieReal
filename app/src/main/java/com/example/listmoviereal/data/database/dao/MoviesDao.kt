package com.example.listmoviereal.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.listmoviereal.data.database.entities.MoviesEntity


@Dao
interface MoviesDao {

    @Query("SELECT * FROM movie_table ORDER BY titulo DESC")
    suspend fun getAllQuotes():List<MoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<MoviesEntity>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllQuotes()
}