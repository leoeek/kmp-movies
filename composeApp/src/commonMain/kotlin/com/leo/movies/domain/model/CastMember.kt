package com.leo.movies.domain.model

data class CastMember(
    val id: Int,
    val mainRole: String,
    val name: String,
    val character: String,
    val profileUrl: String?,
)

// fake objects
val castMember1 = CastMember(
    id = 1,
    mainRole = "Acting",
    name = "John Doe",
    character = "John Doe",
    profileUrl = "url",
)

val castMember2 = CastMember(
    id = 2,
    mainRole = "Acting",
    name = "Jane Doe",
    character = "Jane Doe",
    profileUrl = "url",
)