package com.salhugues.zephoraplayground.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DmReview(
    val productId: Long?,
    val hide: Boolean?,
    val reviews: List<DmReview>?
)
