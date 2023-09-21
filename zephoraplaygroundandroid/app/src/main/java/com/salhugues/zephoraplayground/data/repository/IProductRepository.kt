package com.salhugues.zephoraplayground.data.repository

import com.salhugues.zephoraplayground.domain.model.DmProduct
import com.salhugues.zephoraplayground.misc.ResultState

interface IProductRepository {
    suspend fun getProducts(): ResultState<List<DmProduct>>
    fun getLocalProducts(): List<DmProduct>
    suspend fun saveAllProducts(products: List<DmProduct>)
}