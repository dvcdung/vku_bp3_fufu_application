package com.example.fufu.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fufu.asset.Helper
import com.example.fufu.data.model.Review
import com.example.fufu.databinding.RestaurantReviewItemLayoutBinding

class RestaurantReviewItemAdapter(private var reviewList: List<Review>): RecyclerView.Adapter<RestaurantReviewItemAdapter.ViewHolder>() {
    fun setReviewList(_reviewList: List<Review>) {
        reviewList = _reviewList
    }

    class ViewHolder(binding: RestaurantReviewItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        private val bindingItem = binding
        fun bind(review: Review) {
            review.createdAt = Helper().getDate(review.createdAt)
            bindingItem.review = review
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RestaurantReviewItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reviewList[position])
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }
}