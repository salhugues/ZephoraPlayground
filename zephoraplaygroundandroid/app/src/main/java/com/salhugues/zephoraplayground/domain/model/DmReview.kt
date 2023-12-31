package com.salhugues.zephoraplayground.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DmReview(
    val productId: Long?,
    val name: String?,
    val text: String?,
    val rating: Float?
)
