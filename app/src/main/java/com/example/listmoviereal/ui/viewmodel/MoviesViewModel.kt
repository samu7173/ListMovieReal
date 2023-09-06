package com.example.listmoviereal.ui.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listmoviereal.domain.GetMoviesUseCase
import com.example.listmoviereal.domain.model.Movies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _moviesLiveData = MutableLiveData<List<Movies>>()
    val moviesLiveData: LiveData<List<Movies>> get() = _moviesLiveData
    private val allMovies = mutableListOf<Movies>()

    fun onCreate() {
        viewModelScope.launch {
            val result = getMoviesUseCase()
            if (!result.isNullOrEmpty()) {
                allMovies.addAll(result)
                _moviesLiveData.postValue(result)
            }
        }
    }

    fun filterMoviesByTitle(titleQuery: String):List<Movies> {
            val superherofilter = allMovies.filter { movie -> movie.titulo.contains(titleQuery, ignoreCase = true) }
            return superherofilter
    }

}



