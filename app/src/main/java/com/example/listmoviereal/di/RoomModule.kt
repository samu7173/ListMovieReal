package com.example.listmoviereal.di

import android.content.Context
import androidx.room.Room
import com.example.listmoviereal.data.database.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val QUOTE_DATABASE_NAME="quote_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MoviesDatabase::class.java , QUOTE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db:MoviesDatabase)=db.getQuoteDao()

}