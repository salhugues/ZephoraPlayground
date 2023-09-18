package com.salhugues.zephoraplayground.presentation.model

import kotlinx.serialization.Serializable

@Serializable
data class Review(
    val productId: Long?,
    val hide: Boolean?,
    val reviews: List<Review>?
)
