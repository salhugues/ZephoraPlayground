package com.salhugues.zephoraplayground.data.offline.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "Reviews",
    foreignKeys = [ForeignKey(
        entity = DbProduct::class,
        parentColumns = arrayOf("productId"),
        childColumns = arrayOf("relProductId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class DbReview(
    @ColumnInfo(name = "relProductId")
    val reviewId: String?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "text")
    val text: String?,
    @ColumnInfo(name = "rating")
    val rating: Float?
)
