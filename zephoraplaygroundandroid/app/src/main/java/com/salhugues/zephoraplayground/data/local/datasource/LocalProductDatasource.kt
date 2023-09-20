package com.salhugues.zephoraplayground.data.local.datasource

import com.salhugues.zephoraplayground.data.local.dao.ProductDao
import com.salhugues.zephoraplayground.data.local.mapper.DbProductMapper
import com.salhugues.zephoraplayground.domain.model.DmProduct

class LocalProductDatasource(
    private val productDao: ProductDao
) {
    suspend fun insertAllProducts(products: List<DmProduct>) {
        productDao.insertAll(products.map { dmProduct ->
            DbProductMapper.revert(dmProduct)
        })
    }

    fun getAllProducts(): List<DmProduct> {
        return productDao.getAll().map {
            DbProductMapper.transform(it)
        }
    }
}
