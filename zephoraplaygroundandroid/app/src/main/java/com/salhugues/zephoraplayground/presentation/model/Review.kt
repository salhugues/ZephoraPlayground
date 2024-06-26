package com.salhugues.zephoraplayground.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Review(
    val name: String?,
    val text: String?,
    val rating: Float?
) : Parcelable
