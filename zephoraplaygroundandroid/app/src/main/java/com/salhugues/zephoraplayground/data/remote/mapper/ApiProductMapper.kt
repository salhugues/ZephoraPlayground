package com.salhugues.zephoraplayground.data.remote.mapper

import com.salhugues.zephoraplayground.data.remote.model.ApiProduct
import com.salhugues.zephoraplayground.domain.model.DmProduct
import com.salhugues.zephoraplayground.misc.Mapper

internal object ApiProductMapper : Mapper<List<ApiProduct>, List<DmProduct>> {
    override fun transform(apiProducts: List<ApiProduct>): List<DmProduct> {

        val products = mutableListOf<DmProduct>()

        apiProducts.forEach { apiProduct ->
            products.add(
                DmProduct(
                    productId = apiProduct.productId,
                    productName = apiProduct.productName,
                    description = apiProduct.description,
                    price = apiProduct.price,
                    imageUrl = apiProduct.imageUrl?.small,
                    brand = apiProduct.brand?.name,
                    isProductSet = apiProduct.isProductSet,
                    isSpecialBrand = apiProduct.isSpecialBrand
                )
            )
        }
        return products
    }
}