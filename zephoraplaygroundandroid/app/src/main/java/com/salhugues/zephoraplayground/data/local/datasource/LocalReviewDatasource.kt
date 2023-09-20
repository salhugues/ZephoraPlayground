package com.salhugues.zephoraplayground.data.local.datasource

import com.salhugues.zephoraplayground.data.local.dao.ReviewDao
import com.salhugues.zephoraplayground.data.local.mapper.DbReviewMapper
import com.salhugues.zephoraplayground.domain.model.DmReview

class LocalReviewDatasource(
    private val reviewDao: ReviewDao
) {
    suspend fun insertAllReviews(reviews: List<DmReview>) {
        reviewDao.insertAll(
            reviews.map {
                DbReviewMapper.revert(it)
            }
        )
    }

    fun getAllReviews(): List<DmReview> {
        return reviewDao.getAll().map {
            DbReviewMapper.transform(it)
        }
    }
    fun getReviewsByProductId(productId: Long): List<DmReview> {
        return reviewDao.getReviewsByProductId(productId).map {
            DbReviewMapper.transform(it)
        }
    }
}
