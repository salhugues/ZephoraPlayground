package com.salhugues.zephoraplayground.data.repository

import com.salhugues.zephoraplayground.data.local.datasource.LocalProductDatasource
import com.salhugues.zephoraplayground.data.remote.datasource.RemoteProductDatasource
import com.salhugues.zephoraplayground.domain.model.DmProduct
import com.salhugues.zephoraplayground.misc.ResultState

class ProductRepository(
    private val remoteDatasource: RemoteProductDatasource,
    private val localDatasource: LocalProductDatasource
) {
    suspend fun getProducts(): ResultState<List<DmProduct>> =
        remoteDatasource.getAllProduct()

    suspend fun getLocalProducts(): List<DmProduct> =
        localDatasource.getAllProducts()

    suspend fun saveAllProducts(products: List<DmProduct>) =
        localDatasource.insertAllProducts(products)

}