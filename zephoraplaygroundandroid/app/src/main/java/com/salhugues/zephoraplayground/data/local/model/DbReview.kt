package com.salhugues.zephoraplayground.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Review",
    foreignKeys = [ForeignKey(
        entity = DbProduct::class,
        parentColumns = arrayOf("productId"),
        childColumns = arrayOf("relProductId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class DbReview(
    @PrimaryKey
    @ColumnInfo(name = "relProductId")
    val reviewId: Long?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "text")
    val text: String?,
    @ColumnInfo(name = "rating")
    val rating: Float?
)
