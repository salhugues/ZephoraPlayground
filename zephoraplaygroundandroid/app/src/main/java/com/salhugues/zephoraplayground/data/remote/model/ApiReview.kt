package com.salhugues.zephoraplayground.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiReview(
    val name: String?,
    val text: String?,
    val rating: Float?
)
