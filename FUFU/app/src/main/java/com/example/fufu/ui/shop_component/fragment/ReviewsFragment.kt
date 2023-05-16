package com.example.fufu.ui.shop_component.fragment

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.get
import com.example.fufu.R
import com.example.fufu.data.model.Review
import com.example.fufu.databinding.FragmentReviewsBinding
import com.example.fufu.ui.adapter.RestaurantReviewItemAdapter
import com.example.fufu.ui.shop_component.viewmodel.ReviewsViewModel

class ReviewsFragment : Fragment() {
    private lateinit var reviewsViewModel: ReviewsViewModel
    private lateinit var reviewsBinding: FragmentReviewsBinding
    private lateinit var reviewListLiveData: LiveData<List<Review>>
    private lateinit var restaurantReviewItemAdapter: RestaurantReviewItemAdapter

    //Variable
    private lateinit var userId: String
    private lateinit var resId: String
    private var reviewsList: List<Review> = emptyList()
    private var myReview: List<Review> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //userId
        userId = activity?.intent?.getStringExtra("userId").toString()
        resId = activity?.intent?.getStringExtra("resId").toString()
        //view model
        reviewsViewModel = ViewModelProvider(this)[ReviewsViewModel::class.java]
        //binding
        reviewsBinding = FragmentReviewsBinding.inflate(layoutInflater)
        //livedata
        reviewListLiveData = reviewsViewModel.reviewListLiveData
        //adapter
        restaurantReviewItemAdapter = RestaurantReviewItemAdapter(emptyList())
        //recyclerview
        reviewsBinding.rcvRestaurantReviewList.adapter = restaurantReviewItemAdapter
        reviewsViewModel.getReviewList(resId, userId)
        reviewListLiveData.observe(viewLifecycleOwner) {
            reviewsList = it
            if(it[0].userId == userId) {
                myReview = listOf(it[0])
            }
            restaurantReviewItemAdapter.setReviewList(reviewsList)
            restaurantReviewItemAdapter.notifyDataSetChanged()
        }

        return reviewsBinding.root
    }

}