package com.example.fufu.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fufu.R
import com.example.fufu.data.model.FoodCanYouLike
import com.example.fufu.data.model.HomeFood
import com.example.fufu.data.network.food.ClickItemFoodCan
import com.example.fufu.data.network.food.ClickItemFoodHome
import com.google.android.material.card.MaterialCardView

class FoodHomeYouLikeAdapter(val foodHomeLikeList: List<FoodCanYouLike>, var itemListener: ClickItemFoodCan)
    : RecyclerView.Adapter<FoodHomeYouLikeAdapter.FoodHomeListViewHolder>(){

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
        val homeFoodYouLike: FoodCanYouLike = foodHomeLikeList[position]
        Glide.with(holder.foodName.context).load("http://192.168.1.131:80/fufuAPI/images/" + homeFoodYouLike.itemImg).into(holder.foodImg)
        holder.foodName.text = homeFoodYouLike.itemName
        holder.foodPrice.text = homeFoodYouLike.itemPrice.toString()

        holder.itemClick.setOnClickListener {
            itemListener.onClickItemFoodCan(homeFoodYouLike)
        }
    }

    override fun getItemCount() = foodHomeLikeList.size

}