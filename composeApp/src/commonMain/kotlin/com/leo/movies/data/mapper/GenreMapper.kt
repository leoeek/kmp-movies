package com.leo.movies.data.mapper

import com.leo.movies.domain.model.Genre
import com.leo.movies.data.network.model.GenreResponse

fun GenreResponse.toModel() = Genre(
    id = this.id,
    name = this.name,
)