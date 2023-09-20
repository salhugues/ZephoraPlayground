package com.salhugues.zephoraplayground.data.remote.api

import com.salhugues.zephoraplayground.data.remote.model.ApiProduct
import com.salhugues.zephoraplayground.data.remote.model.ApiReviews
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("testProject/items.json")
    suspend fun getProducts(): Response<List<ApiProduct>>

    @GET("testProject/reviews.json")
    suspend fun getReviews(): Response<List<ApiReviews>>
}
