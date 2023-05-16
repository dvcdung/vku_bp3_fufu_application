package com.example.fufu.ui.main_component.fragment

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fufu.R
import com.example.fufu.asset.Helper
import com.example.fufu.databinding.FragmentHomeBinding
import com.example.fufu.ui.main_component.viewmodel.HomeViewModel
import com.example.fufu.ui.shop_component.RestaurantActivity

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeBinding: FragmentHomeBinding
    //btn
    private lateinit var btnDeals: ImageButton
    private lateinit var btnShop: ImageButton
    private lateinit var btnFavorite: ImageButton
    private lateinit var btnTravel: ImageButton

    companion object {
        fun newInstance() = HomeFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //view model
        //binding
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        //live data
        //adapter
        //button
        btnDeals = homeBinding.btnDeals
        btnShop = homeBinding.btnShop
        btnFavorite = homeBinding.btnFavorite
        btnTravel = homeBinding.btnTravel
        //navigation

        return homeBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnShop.setOnClickListener {
            if(Helper().checkUserRole(requireContext())) {
                val intent = Intent(activity, RestaurantActivity::class.java)
                intent.putExtra("userId", Helper().getCurrentUser(requireContext()))
                intent.putExtra("resId", Helper().getCurrentResId(requireContext()))
                startActivity(intent)
            }
        }
    }
}