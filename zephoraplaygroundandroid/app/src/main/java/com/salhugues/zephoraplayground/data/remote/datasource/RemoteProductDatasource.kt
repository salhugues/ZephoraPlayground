package com.salhugues.zephoraplayground.data.remote.datasource

import com.salhugues.zephoraplayground.data.remote.api.ApiClient
import com.salhugues.zephoraplayground.data.remote.mapper.ApiProductMapper
import com.salhugues.zephoraplayground.domain.model.DmProduct
import com.salhugues.zephoraplayground.misc.ResultState

class RemoteProductDatasource(
    private val apiClient: ApiClient
) {
    suspend fun getAllProduct(): ResultState<List<DmProduct>> {
        val result = apiClient.getProducts()

        return if (result.isSuccessful) {
            ResultState.success(
                ApiProductMapper.transform(result.body() ?: listOf())
            )
        } else {
            ResultState.error(result.message(), null)
        }
    }
}
