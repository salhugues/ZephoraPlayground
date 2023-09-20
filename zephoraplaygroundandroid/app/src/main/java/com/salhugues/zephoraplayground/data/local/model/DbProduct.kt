package com.salhugues.zephoraplayground.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Product")
data class DbProduct(
    @ColumnInfo(name = "productId") val productId: Long?,
    @ColumnInfo(name = "productName") val productName: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "price") val price: Float?,
    @ColumnInfo(name = "imageUrl") val imageUrl: String?,
    @ColumnInfo(name = "brand") val brand: String?,
    @ColumnInfo(name = "isProductSet") val isProductSet: Boolean?,
    @ColumnInfo(name = "isSpecialBrand") val isSpecialBrand: Boolean?
)
