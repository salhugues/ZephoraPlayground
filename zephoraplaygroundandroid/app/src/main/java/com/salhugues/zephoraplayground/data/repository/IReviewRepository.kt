package com.salhugues.zephoraplayground.data.repository

import com.salhugues.zephoraplayground.domain.model.DmReview
import com.salhugues.zephoraplayground.misc.ResultState

interface IReviewRepository {
    suspend fun getReviews(): ResultState<List<DmReview>>

    fun getLocalReviews(): List<DmReview>

    suspend fun saveAllReviews(reviews: List<DmReview>)
}