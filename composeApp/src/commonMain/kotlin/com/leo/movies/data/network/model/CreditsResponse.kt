package com.leo.movies.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreditsListResponse(
    val id: Int,
    val cast: List<CastMemberResponse>,
)

@Serializable
data class CastMemberResponse(
    val id: Int,
    @SerialName("known_for_department")
    val knownForDepartment: String,
    val name: String,
    val character: String,
    @SerialName("profile_path")
    val profilePath: String? = null, //  pode ser nulo
)