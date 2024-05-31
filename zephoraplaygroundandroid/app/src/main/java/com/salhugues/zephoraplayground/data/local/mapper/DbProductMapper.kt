package com.salhugues.zephoraplayground.data.local.mapper

import com.salhugues.zephoraplayground.data.local.model.DbProduct
import com.salhugues.zephoraplayground.domain.model.DmProduct
import com.salhugues.zephoraplayground.misc.TwoWayMapper

internal object DbProductMapper : TwoWayMapper<DbProduct, DmProduct> {
    override fun transform(item: DbProduct): DmProduct {
        return DmProduct(
            productId = item.productId,
            productName = item.productName,
            description = item.description,
            price = item.price,
            imageUrl = item.imageUrl,
            brand = item.brand,
            isProductSet = item.isProductSet,
            isSpecialBrand = item.isSpecialBrand
        )
    }

    override fun revert(item: DmProduct): DbProduct {
        return DbProduct(
            productId = item.productId,
            productName = item.productName,
            description = item.description,
            price = item.price,
            imageUrl = item.imageUrl,
            brand = item.brand,
            isProductSet = item.isProductSet,
            isSpecialBrand = item.isSpecialBrand
        )
    }
}
