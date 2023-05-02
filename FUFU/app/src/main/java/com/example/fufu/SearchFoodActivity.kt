package com.example.fufu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fufu.data.model.FoodSearchModel
import com.example.fufu.databinding.ActivitySearchFoodBinding
import com.example.fufu.ui.adapter.FoodSearchAdapter

class SearchFoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchFoodBinding

    private var foodList = ArrayList<FoodSearchModel>()
    private var linearLayoutManager: LinearLayoutManager? = null
    private var foodSearchAdapter: FoodSearchAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addListFoodSearch()

        foodSearchAdapter = FoodSearchAdapter(foodList, applicationContext)
        linearLayoutManager = LinearLayoutManager(applicationContext)
        binding.rcView.layoutManager = linearLayoutManager
        binding.rcView.adapter = foodSearchAdapter
        foodSearchAdapter?.notifyDataSetChanged()
    }

    private fun addListFoodSearch() {
        foodList.add(FoodSearchModel(R.drawable.food_test, "123123123", "123123123", 123))
        foodList.add(FoodSearchModel(R.drawable.food_test, "123123123", "123123123", 123))
        foodList.add(FoodSearchModel(R.drawable.food_test, "123123123", "123123123", 123))
        foodList.add(FoodSearchModel(R.drawable.food_test, "123123123", "123123123", 123))
    }
}