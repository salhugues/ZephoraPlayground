package com.salhugues.zephoraplayground.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiReviews(
    @SerialName("product_id") val productId: Long?,
    val hide: Boolean?,
    val reviews: List<ApiReview>?
)
