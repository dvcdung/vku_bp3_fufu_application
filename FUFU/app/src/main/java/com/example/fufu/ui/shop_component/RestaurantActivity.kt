package com.example.fufu.ui.shop_component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fufu.databinding.ActivityRestaurantBinding
import com.example.fufu.ui.common.action.HeaderLayoutAction

class RestaurantActivity : AppCompatActivity() {
    lateinit var binding: ActivityRestaurantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        HeaderLayoutAction(this)
    }
}