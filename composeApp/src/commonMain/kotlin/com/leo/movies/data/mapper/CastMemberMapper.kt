package com.leo.movies.data.mapper

import com.leo.movies.data.network.IMAGE_BASE_URL
import com.leo.movies.domain.model.CastMember
import com.leo.movies.data.network.model.CastMemberResponse
import com.leo.movies.domain.model.ImageSize

fun CastMemberResponse.toModel() = CastMember(
    id = this.id,
    mainRole = this.knownForDepartment,
    name = this.name,
    character = this.character,
    profileUrl = "$IMAGE_BASE_URL/${ImageSize.X_SMALL.size}/${this.profilePath}",
)