package com.leo.movies.domain.model

data class MovieSection(
    val sectionType: SectionTypes,
    val movies: List<Movie>
) {
    enum class SectionTypes {
        POPULAR,
        UPCOMING,
        TOP_RATED
    }
}