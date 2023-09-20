package com.salhugues.zephoraplayground.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiProduct(
    @SerialName("product_id") val productId: Long?,
    @SerialName("product_name") val productName: String?,
    @SerialName("description") val description: String?,
    @SerialName("price") val price: Float?,
    @SerialName("image_url") val imageUrl: ApiImageUrl?,
    @SerialName("c_brand") val brand: ApiBrand?,
    @SerialName("is_productSet") val isProductSet: Boolean?,
    @SerialName("is_special_brand") val isSpecialBrand: Boolean?
)
