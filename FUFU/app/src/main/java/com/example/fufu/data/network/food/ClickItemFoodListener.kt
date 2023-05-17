package com.example.fufu.data.network.food

import com.example.fufu.data.model.FoodSearchModel
import com.example.fufu.data.model.HomeFood

interface ClickItemFoodListener {

    fun onClickItemFood(food: FoodSearchModel)

}