package com.salhugues.zephoraplayground.domain.usecase

import com.salhugues.zephoraplayground.domain.model.DmProduct
import com.salhugues.zephoraplayground.domain.model.DmReview
import com.salhugues.zephoraplayground.presentation.model.Product
import com.salhugues.zephoraplayground.presentation.model.Review

class GetProductFormatterUseCase {
    operator fun invoke(
        dmProducts: List<DmProduct>,
        dmReviews: List<DmReview>
    ): List<Product> {
        val products = mutableListOf<Product>()

        dmProducts.forEach { dmProduct ->
            products.add(
                Product(
                    productId = dmProduct.productId,
                    productName = dmProduct.productName,
                    description = dmProduct.description,
                    imageUrl = dmProduct.imageUrl,
                    brand = dmProduct.brand,
                    reviews = getReviewByProductId(dmProduct.productId, dmReviews)
                )
            )
        }
        return products
    }

    private fun getReviewByProductId(
        productId: Long?,
        dmReviews: List<DmReview>
    ): List<Review> {

        return dmReviews.filter { dmReview ->
            dmReview.productId == productId
        }.map {
            Review(
                it.name,
                it.text,
                it.rating
            )
        }
    }
}