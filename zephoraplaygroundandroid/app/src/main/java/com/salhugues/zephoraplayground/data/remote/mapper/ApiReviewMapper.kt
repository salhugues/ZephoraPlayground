package com.salhugues.zephoraplayground.data.remote.mapper

import com.salhugues.zephoraplayground.data.remote.model.ApiReviews
import com.salhugues.zephoraplayground.domain.model.DmReview
import com.salhugues.zephoraplayground.misc.Mapper

internal object ApiReviewMapper : Mapper<List<ApiReviews>, List<DmReview>> {
    override fun transform(apiReviews: List<ApiReviews>): List<DmReview> {

        val reviews = mutableListOf<DmReview>()

        apiReviews.forEach { apiReview ->
            apiReview.reviews?.forEach { review ->
                reviews.add(
                    DmReview(
                        productId = apiReview.productId,
                        name = review.name,
                        text = review.text,
                        rating = review.rating
                    )
                )
            }
        }
        return reviews
    }
}