package com.example.fufu.data.network.restaurant

import com.example.fufu.data.model.Restaurant
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantApi {
    @GET("api/restaurant/{userId}")
    suspend fun getRestaurantByUserId(@Path("userId") userId: String): List<Restaurant>
}