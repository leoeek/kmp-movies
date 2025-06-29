package com.leo.movies.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leo.movies.data.repository.MoviesRepository
import com.leo.movies.domain.model.MovieSection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesListViewModel(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val _moviesListState = MutableStateFlow<MoviesListState>(MoviesListState.Loading)
    val movieListState = _moviesListState.asStateFlow()

    init {
        getMovieSection()
    }

    private fun getMovieSection() {
        viewModelScope.launch {
            try {
                val movieSections = moviesRepository.getMovieSections()
                _moviesListState.update {
                    MoviesListState.Success(movieSections)
                }
            } catch (e: Exception) {
                _moviesListState.update {
                    MoviesListState.Error(e.message ?: "Unknown error")
                }
            }
        }
    }

    sealed interface MoviesListState {
        data object Loading : MoviesListState
        data class Success(val movieSections: List<MovieSection>) : MoviesListState
        data class Error(val message: String) : MoviesListState
    }
}