package com.example.fufu.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fufu.R
import com.example.fufu.data.model.FoodSearchModel
import com.example.fufu.data.model.HomeFood
import com.example.fufu.data.network.food.ClickItemFoodHome
import com.example.fufu.data.network.food.ClickItemFoodListener
import com.google.android.material.card.MaterialCardView

class FoodHomeListAdapter(var foodHomeList: List<HomeFood>, var itemListener: ClickItemFoodHome)
    : RecyclerView.Adapter<FoodHomeListAdapter.FoodHomeListViewHolder>(){

    class FoodHomeListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodImg: ImageView = view.findViewById(R.id.img_food_around_you)
        val foodName: TextView = view.findViewById(R.id.item_name_around_you)
        val foodPrice: TextView = view.findViewById(R.id.item_price_around_you)
        val itemClick: MaterialCardView = view.findViewById(R.id.layoutClick2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHomeListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_around_you_item_layout, parent, false)
        return FoodHomeListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodHomeListViewHolder, position: Int) {
        val homeFood: HomeFood = foodHomeList[position]
        Glide.with(holder.foodName.context).load("http://192.168.1.131:80/fufuAPI/images/" + homeFood.itemImg).into(holder.foodImg)
        holder.foodName.text = homeFood.itemName
        holder.foodPrice.text = homeFood.itemPrice.toString()

        holder.itemClick.setOnClickListener {
            itemListener.onClickItemFoodHome(homeFood)
        }
    }

    override fun getItemCount() = foodHomeList.size

    fun setFilteredList(foodList: List<HomeFood>){
        this.foodHomeList = foodList
        notifyDataSetChanged()
    }
}