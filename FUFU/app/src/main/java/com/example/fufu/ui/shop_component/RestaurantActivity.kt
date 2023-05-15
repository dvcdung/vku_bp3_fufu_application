package com.example.fufu.ui.shop_component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.fufu.data.network.RetrofitHelper
import com.example.fufu.data.network.restaurant.MenuApi
import com.example.fufu.databinding.ActivityRestaurantBinding
import com.example.fufu.ui.common.action.HeaderLayoutAction
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RestaurantActivity : AppCompatActivity() {
    lateinit var binding: ActivityRestaurantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Action of header layout
        HeaderLayoutAction(this)

        Log.e("TAG", intent.getStringExtra("userId").toString())
    }
}