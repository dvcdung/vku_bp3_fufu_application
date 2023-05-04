package com.example.fufu.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.fufu.data.model.Item
import com.example.fufu.databinding.RestaurantMenuItemLayoutBinding
import com.example.fufu.ui.shop_component.viewmodel.RestaurantDetailViewModel

class RestaurantMenuItemAdapter(private var menuList: List<Item>) : RecyclerView.Adapter<RestaurantMenuItemAdapter.ViewHolder>() {

    fun setMenuList(_menuList: List<Item>) {
        menuList = _menuList
    }

    class ViewHolder(binding: RestaurantMenuItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        private val bindingItem = binding
        fun bind(item: Item) {
            bindingItem.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RestaurantMenuItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(menuList[position])
    }

    override fun getItemCount(): Int {
        return menuList.size
    }
}