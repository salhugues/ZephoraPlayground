package com.salhugues.zephoraplayground.data.online.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiImageUrl(
    val small: String?,
    val large: String?
)
