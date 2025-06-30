package com.leo.movies.data.mapper

import com.leo.movies.data.network.model.VideosListResponse
import com.leo.movies.domain.model.Video

private const val BASE_YOUTUBE_URL = "https://www.youtube.com/watch?v="
private const val YOUTUBE = "YouTube"
private const val TRAILER = "Trailer"

fun VideosListResponse.toModel(): Video {
    if (this.results.isEmpty()) {
        throw IllegalStateException("Trailer não encontrado!")
    }

    val videoResult = this.results
        .firstOrNull { it.site == YOUTUBE && it.type == TRAILER && it.official }

    if (videoResult == null) {
        throw IllegalStateException("Trailer não encontrado!")
    }

    return Video(
        name = videoResult.name,
        url = BASE_YOUTUBE_URL + videoResult.key
    )
}