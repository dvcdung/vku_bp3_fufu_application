package com.example.fufu.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fufu.R
import com.example.fufu.data.model.FoodSearchModel

class FoodSearchAdapter(foodSearchList: List<FoodSearchModel>, var context: Context)
    : RecyclerView.Adapter<FoodSearchAdapter.FoodViewHolder>(){

    private var foodList: List<FoodSearchModel> = ArrayList()

    init {
        this.foodList = foodSearchList
    }

    class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodImg: ImageView = view.findViewById(R.id.img_food)
        val foodName: TextView = view.findViewById(R.id.item_name)
        val foodRes: TextView = view.findViewById(R.id.item_res)
        val foodPrice: TextView = view.findViewById(R.id.item_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.foodImg.setImageResource(foodList[position].logo)
        holder.foodName.text = foodList[position].foodName
        holder.foodRes.text = foodList[position].foodRes
        holder.foodPrice.text = foodList[position].foodPrice.toString()
    }

    override fun getItemCount() = foodList.size

}