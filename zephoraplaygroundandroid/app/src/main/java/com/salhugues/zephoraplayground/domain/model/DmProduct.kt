package com.salhugues.zephoraplayground.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DmProduct(
    val productId: Long?,
    val productName: String?,
    val description: String?,
    val price: Float?,
    val imageUrl: String?,
    val brand: String?,
    val isProductSet: Boolean?,
    val isSpecialBrand: Boolean?
)
