package com.leo.movies.data.repository

import com.leo.movies.data.mapper.toModel
import com.leo.movies.data.network.KtorClient
import com.leo.movies.domain.model.ImageSize
import com.leo.movies.domain.model.Movie
import com.leo.movies.domain.model.MovieSection
import com.leo.movies.domain.model.Video
import io.ktor.http.ContentType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MoviesRepository(
    private val ktorClient: KtorClient,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
)  {

    suspend fun getMovieSections(): List<MovieSection> {
        return withContext(ioDispatcher) {
            val popularMoviesDeferred = async { ktorClient.getMovies("popular") }
            val topRatedMoviesDeferred = async { ktorClient.getMovies("top_rated") }
            val upcommingMoviesDeferred = async { ktorClient.getMovies("upcoming") }

            val popularMovies = popularMoviesDeferred.await()
            val topRatedMovies = topRatedMoviesDeferred.await()
            val upcommingMovies = upcommingMoviesDeferred.await()

            listOf(
                MovieSection(
                    sectionType = MovieSection.SectionTypes.POPULAR,
                    movies = popularMovies.results.map {
                        it.toModel()
                    }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionTypes.TOP_RATED,
                    movies = topRatedMovies.results.map {
                        it.toModel()
                    }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionTypes.UPCOMING,
                    movies = upcommingMovies.results.map {
                        it.toModel()
                    }
                ),
            )

        }
    }

    suspend fun getMovieDetail(movieId: Int): Result<Movie> {
        return withContext(ioDispatcher) {
            runCatching {
                val movieDetailDeferred = async { ktorClient.getMovieDetail(movieId) }
                val creditsDeferred = async { ktorClient.getCredits(movieId) }

                val movieDetailResponse = movieDetailDeferred.await()
                val creditsResponse = creditsDeferred.await()

                movieDetailResponse.toModel(
                    castMembersResponse = creditsResponse.cast,
                    imageSize = ImageSize.X_LARGE,
                )
            }
        }
    }

    suspend fun getVideos(movieId: Int): Result<Video> {
        return withContext(ioDispatcher) {
            runCatching {
                val videoDeferred = async { ktorClient.getVideos(movieId) }
                val videosResponse = videoDeferred.await()
                videosResponse.toModel()
            }
        }
    }

}