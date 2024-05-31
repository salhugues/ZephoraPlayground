package com.salhugues.zephoraplayground.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val productId: Long?,
    val productName: String?,
    val description: String?,
    val imageUrl: String?,
    val brand: String?,
    val reviews: List<Review>?
) : Parcelable
