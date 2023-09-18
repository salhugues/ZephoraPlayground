package com.salhugues.zephoraplayground.data.online.api

import com.salhugues.zephoraplayground.data.online.model.ApiProduct
import com.salhugues.zephoraplayground.data.online.model.ApiReview
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("testProject/items.json")
    suspend fun getProducts(): Response<ApiProduct>
    @GET("testProject/reviews.json")
    suspend fun getReviews(): Response<ApiReview>
}
