package com.leo.movies.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.leo.movies.domain.model.MovieSection
import com.leo.movies.domain.model.movie1
import com.leo.movies.ui.components.CastMemberItem
import com.leo.movies.ui.components.MovieGenreChip
import com.leo.movies.ui.components.MovieInfoItem
import com.leo.movies.ui.components.MoviePoster
import com.leo.movies.ui.moviedetail.MovieDetailScreen
import com.leo.movies.ui.moviedetail.MovieDetailViewModel
import com.leo.movies.ui.movies.MoviesListScreen
import com.leo.movies.ui.movies.MoviesListViewModel
import com.leo.movies.ui.theme.MoviesAppTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Star

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        movie = movie1,
                onMoviePosterClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun MovieListScreenPreview() {
    MoviesAppTheme {
        MoviesListScreen(
            movieListState = MoviesListViewModel.MoviesListState.Success(
                movieSections = listOf(
                    MovieSection(
                        sectionType = MovieSection.SectionTypes.POPULAR,
                        movies = listOf(
                            movie1
                        )
                    )
                )
            ),
            onMovieClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesDetailScreenPreview() {
    MoviesAppTheme {
        MovieDetailScreen(
            movieDetailState = MovieDetailViewModel.MovieDetailState.Success(movie1),
            onNavigationIconClick = {},
            videoState = MovieDetailViewModel.VideoState.Loading,
            onVideoClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieInfoItemPreview() {
    MoviesAppTheme {
        MovieInfoItem(
            icon = FontAwesomeIcons.Solid.Star,
            text = "7.5"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieGenreChipPreview() {
    MoviesAppTheme {
        MovieGenreChip(
            genre = "Action"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CastMemberItemPreview() {
    MoviesAppTheme {
        CastMemberItem(
            profilePictureUrl = "",
            name = "Will Smith",
            character = "Christopher Gardner",
        )
    }
}