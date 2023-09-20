package com.salhugues.zephoraplayground.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiImageUrl(
    val small: String?,
    val large: String?
)
