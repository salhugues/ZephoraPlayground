package com.salhugues.zephoraplayground.data.remote.datasource

import com.salhugues.zephoraplayground.data.remote.api.ApiClient
import com.salhugues.zephoraplayground.data.remote.mapper.ApiReviewMapper
import com.salhugues.zephoraplayground.domain.model.DmReview
import com.salhugues.zephoraplayground.misc.ResultState

class RemoteReviewDatasource(
    private val apiClient: ApiClient
) {
    suspend fun getAllReviews(): ResultState<List<DmReview>> {
        val result = apiClient.getReviews()

        return if (result.isSuccessful) {
            ResultState.success(
                ApiReviewMapper.transform(result.body() ?: listOf())
            )
        } else {
            ResultState.error(result.message(), null)
        }
    }
}
