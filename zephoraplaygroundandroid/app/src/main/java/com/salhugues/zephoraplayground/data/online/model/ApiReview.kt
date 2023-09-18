package com.salhugues.zephoraplayground.data.online.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiReview(
    @SerialName("product_id") val productId: Long?,
    val hide: Boolean?,
    val reviews: List<ApiReview>?
)
