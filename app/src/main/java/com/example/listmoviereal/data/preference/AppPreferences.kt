package com.example.listmoviereal.data.preference

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AppPreferences@Inject constructor(@ApplicationContext context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun hasDataDownloaded(): Boolean {
        return sharedPreferences.getBoolean("data_downloaded", false)
    }

    fun setDataDownloaded(downloaded: Boolean) {
        sharedPreferences.edit().putBoolean("data_downloaded", downloaded).apply()
    }
}
