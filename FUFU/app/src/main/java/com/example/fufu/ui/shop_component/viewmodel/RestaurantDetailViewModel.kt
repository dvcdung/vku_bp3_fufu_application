package com.example.fufu.ui.shop_component.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fufu.data.model.Item
import com.example.fufu.data.network.RetrofitHelper
import com.example.fufu.data.network.restaurant.MenuApi
import com.example.fufu.data.repository.MenuRepository
import kotlinx.coroutines.launch

class RestaurantDetailViewModel : ViewModel() {
    //repository
    private val menuRepository = MenuRepository()
    //live data
    val menuListLiveData = MutableLiveData<List<Item>>()

    fun getMenuList() {
        viewModelScope.launch {
            val response = menuRepository.getMenuList("1")
            menuListLiveData.value = response
        }
    }
}