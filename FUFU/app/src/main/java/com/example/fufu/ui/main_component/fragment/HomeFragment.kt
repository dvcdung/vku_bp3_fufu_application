package com.example.fufu.ui.main_component.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fufu.R
import com.example.fufu.data.model.FoodCanYouLike
import com.example.fufu.data.model.HomeFood
import com.example.fufu.data.network.food.HomeFoodApi
import com.example.fufu.ui.adapter.FoodHomeListAdapter
import com.example.fufu.ui.adapter.FoodHomeYouLikeAdapter
import com.example.fufu.ui.main_component.viewmodel.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    private lateinit var rcView: RecyclerView
    private lateinit var rcViewYouLike: RecyclerView

    private lateinit var foodAdapter: FoodHomeListAdapter
    private lateinit var foodYouLikeAdapter: FoodHomeYouLikeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcView = view.findViewById(R.id.recycler_view_food_around_you_list)
        rcViewYouLike = view.findViewById(R.id.recycler_view_maybe_you_like_list)

        rcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        rcViewYouLike.layoutManager = GridLayoutManager(context, 2)

        callApi()
        callApiYouLike()
    }

    private fun callApiYouLike() {
        HomeFoodApi.homeFoodYouLikeApi.getDataFoodYouLike().enqueue(object : Callback<List<FoodCanYouLike>>{
            override fun onResponse(
                call: Call<List<FoodCanYouLike>>,
                response: Response<List<FoodCanYouLike>>
            ) {
                val foodListYouLike = response.body()
                if (foodListYouLike != null) {
                    foodYouLikeAdapter = FoodHomeYouLikeAdapter(foodListYouLike)
                    rcViewYouLike.adapter = foodYouLikeAdapter
                }
            }

            override fun onFailure(call: Call<List<FoodCanYouLike>>, t: Throwable) {
                Toast.makeText(context, "Call Failed", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun callApi() {
        HomeFoodApi.homeFoodApi.getDataFood().enqueue(object : Callback<List<HomeFood>>{
            override fun onResponse(
                call: Call<List<HomeFood>>,
                response: Response<List<HomeFood>>
            ) {
                val foodList = response.body()
                if (foodList != null) {
                    foodAdapter = FoodHomeListAdapter(foodList)
                    rcView.adapter = foodAdapter
                }
            }

            override fun onFailure(call: Call<List<HomeFood>>, t: Throwable) {
                Toast.makeText(context, "Call Failed", Toast.LENGTH_SHORT).show()
            }

        })
    }

}