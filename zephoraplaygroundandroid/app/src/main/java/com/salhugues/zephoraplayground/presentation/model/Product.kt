package com.salhugues.zephoraplayground.presentation.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val productId: Long?,
    val productName: String?,
    val description: String?,
    val imageUrl: String?,
    val brand: String?,
    val isProductSet: Boolean?,
    val isSpecialBrand: Boolean?
)
