package com.example.fufu.ui.shop_component.fragment

import android.annotation.SuppressLint
import android.content.ClipData.Item
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import com.example.fufu.R
import com.example.fufu.databinding.FragmentRestaurantDetailBinding
import com.example.fufu.ui.adapter.RestaurantMenuItemAdapter
import com.example.fufu.ui.shop_component.viewmodel.RestaurantDetailViewModel

class RestaurantDetailFragment : Fragment() {
    private lateinit var restaurantDetailViewModel: RestaurantDetailViewModel
    private lateinit var restaurantDetailBinding: FragmentRestaurantDetailBinding
    private lateinit var menuListLiveData: LiveData<List<com.example.fufu.data.model.Item>>
    //Adapter
    private lateinit var restaurantMenuItemAdapter: RestaurantMenuItemAdapter

    companion object {
        fun newInstance() = RestaurantDetailFragment()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //view model
        restaurantDetailViewModel = ViewModelProvider(this)[RestaurantDetailViewModel::class.java]
        //binding
        restaurantDetailBinding = FragmentRestaurantDetailBinding.inflate(layoutInflater)
        //live data
        menuListLiveData = restaurantDetailViewModel.menuListLiveData
        //adapter
        restaurantMenuItemAdapter = RestaurantMenuItemAdapter(emptyList())
        //recyclerview
        restaurantDetailBinding.rcvRestaurantMenuList.adapter = restaurantMenuItemAdapter
        restaurantDetailViewModel.getMenuList()
        restaurantDetailViewModel.menuListLiveData.observe(viewLifecycleOwner) {
            restaurantMenuItemAdapter.setMenuList(it)
            restaurantMenuItemAdapter.notifyDataSetChanged()
        }

        return restaurantDetailBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}