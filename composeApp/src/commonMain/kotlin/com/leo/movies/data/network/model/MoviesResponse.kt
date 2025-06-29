package com.leo.movies.data.network.model

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesListResponse(
    val results: List<MovieResponse>
)

@Serializable
data class MovieResponse(
    val id: Int,
    @SerialName("poster_path")
    val posterPath: String,
    val title: String,
    val overview: String,
    val genres: List<GenreResponse>? = null, // nulo porque no movies list não existe essa prop
    @SerialName("release_date")
    val releaseDate: LocalDate,
    val runtime: Int? = null, // nulo porque no movies list não existe essa prop
    @SerialName("vote_average")
    val voteAverage: Double,
)

@Serializable
data class GenreResponse(
    val id: Int,
    val name: String,
)