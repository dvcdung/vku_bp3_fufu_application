package com.example.fufu.data.network.food

import com.example.fufu.data.model.FoodSearchModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SearchFoodApi {
    companion object {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("http://192.168.61.94:80/fufuAPI/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val searchFoodApi: SearchFoodApi = retrofit.create(SearchFoodApi::class.java)
    }

    @GET("searchItemAPI.php")
    fun getDataSearch() : Call<List<FoodSearchModel>>
}