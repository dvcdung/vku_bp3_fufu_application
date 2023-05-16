package com.example.fufu.data.network.restaurant

import com.example.fufu.data.model.Review
import retrofit2.http.GET
import retrofit2.http.Path

interface ReviewApi {
    @GET("api/restaurant/review/me/{resId}/{userId}")
    suspend fun getReviewByUserId(@Path("resId") resId: String, @Path("userId") userId: String): List<Review>

    @GET("api/restaurant/review/{resId}/{userId}")
    suspend fun getReviewsByResId(@Path("resId") resId: String, @Path("userId") userId: String): List<Review>
}