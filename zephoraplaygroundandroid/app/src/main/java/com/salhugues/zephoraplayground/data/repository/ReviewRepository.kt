package com.salhugues.zephoraplayground.data.repository

import com.salhugues.zephoraplayground.data.local.datasource.LocalReviewDatasource
import com.salhugues.zephoraplayground.data.remote.datasource.RemoteReviewDatasource
import com.salhugues.zephoraplayground.domain.model.DmReview
import com.salhugues.zephoraplayground.misc.ResultState

class ReviewRepository(
    private val remoteDatasource: RemoteReviewDatasource,
    private val localDatasource: LocalReviewDatasource
) {
    suspend fun getReviews(): ResultState<List<DmReview>> =
        remoteDatasource.getAllReviews()

    fun getLocalReviews(): List<DmReview> =
        localDatasource.getAllReviews()

    suspend fun saveAllReviews(reviews: List<DmReview>) {
        localDatasource.insertAllReviews(reviews)
    }
}