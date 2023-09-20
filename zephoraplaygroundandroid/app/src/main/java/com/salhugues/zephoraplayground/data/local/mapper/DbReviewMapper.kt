package com.salhugues.zephoraplayground.data.local.mapper

import com.salhugues.zephoraplayground.data.local.model.DbReview
import com.salhugues.zephoraplayground.domain.model.DmReview
import com.salhugues.zephoraplayground.misc.TwoWayMapper

internal object DbReviewMapper : TwoWayMapper<DbReview, DmReview> {
    override fun transform(dbReview: DbReview): DmReview {
        return DmReview(
            productId = dbReview.reviewId,
            name = dbReview.name,
            text = dbReview.text,
            rating = dbReview.rating
        )
    }

    override fun revert(review: DmReview): DbReview {
        return DbReview(
            reviewId = review.productId,
            name = review.name,
            text = review.text,
            rating = review.rating
        )
    }
}