package com.leo.movies.ui.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.leo.movies.data.repository.MoviesRepository
import com.leo.movies.domain.model.Movie
import com.leo.movies.navigation.AppRoutes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val movieDetailRoute = savedStateHandle.toRoute<AppRoutes.MovieDetail>()

    private val _movieDetailState = MutableStateFlow<MovieDetailState>(MovieDetailState.Loading)
    val movieDetailState = _movieDetailState.asStateFlow()

    private val _videoState = MutableStateFlow<VideoState?>(null)
    val videoState = _videoState.asStateFlow()

    init {
        getMovieDetail()
    }

    private fun getMovieDetail() {
        viewModelScope.launch {
            moviesRepository.getMovieDetail(movieDetailRoute.id).fold(
                onSuccess = { movie ->
                    _movieDetailState.update {
                        MovieDetailState.Success(movie)
                    }
                },
                onFailure = { error ->
                    _movieDetailState.update {
                        MovieDetailState.Error(error.message ?: "Unknown error")
                    }
                }
            )
        }
    }

    fun clearVideoState() {
        _videoState.update { null }
    }

    fun video() {
        viewModelScope.launch {
            _videoState.update { VideoState.Loading }

            moviesRepository.getVideos(movieDetailRoute.id).fold(
                onSuccess = { video ->
                    _videoState.update {
                        VideoState.Success(video.url)
                    }
                },
                onFailure = { error ->
                    _videoState.update {
                        VideoState.Error(error.message ?: "Unknown error")
                    }
                }
            )
        }
    }

    sealed interface MovieDetailState {
        data object Loading : MovieDetailState
        data class Success(val movie: Movie) : MovieDetailState
        data class Error(val message: String) : MovieDetailState
    }

    sealed interface VideoState {
        data object Loading : VideoState
        data class Success(val url: String) : VideoState
        data class Error(val message: String) : VideoState
    }
}