package com.salhugues.zephoraplayground.data.local.mapper

import com.salhugues.zephoraplayground.data.local.model.DbProduct
import com.salhugues.zephoraplayground.domain.model.DmProduct
import com.salhugues.zephoraplayground.misc.TwoWayMapper

internal object DbProductMapper : TwoWayMapper<DbProduct, DmProduct> {
    override fun transform(dbProduct: DbProduct): DmProduct {
        return DmProduct(
            productId = dbProduct.productId,
            productName = dbProduct.productName,
            description = dbProduct.description,
            price = dbProduct.price,
            imageUrl = dbProduct.imageUrl,
            brand = dbProduct.brand,
            isProductSet = dbProduct.isProductSet,
            isSpecialBrand = dbProduct.isSpecialBrand
        )
    }

    override fun revert(product: DmProduct): DbProduct {
        return DbProduct(
            productId = product.productId,
            productName = product.productName,
            description = product.description,
            price = product.price,
            imageUrl = product.imageUrl,
            brand = product.brand,
            isProductSet = product.isProductSet,
            isSpecialBrand = product.isSpecialBrand
        )
    }
}