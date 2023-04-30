package com.example.fufu.ui.shop_component.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fufu.R
import com.example.fufu.ui.shop_component.viewmodel.ReviewsViewModel

class ReviewsFragment : Fragment() {

    companion object {
        fun newInstance() = ReviewsFragment()
    }

    private lateinit var viewModel: ReviewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reviews, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReviewsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}