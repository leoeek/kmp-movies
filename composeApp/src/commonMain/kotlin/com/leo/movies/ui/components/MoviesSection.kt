package com.leo.movies.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.leo.movies.domain.model.Movie

@Composable
fun MoviesSection(
    title: String,
    movies: List<Movie>,
    onMoviePosterClick: (movieId: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = title,
            modifier = Modifier
                .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.titleLarge
        )

        LazyRow(
            modifier = Modifier
                .padding(top = 8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(movies.size) { movie ->
                MoviePoster(
                    movie = movies[movie],
                    onMoviePosterClick = {
                        onMoviePosterClick(movies[movie].id)
                    }
                )
            }
        }
    }
}