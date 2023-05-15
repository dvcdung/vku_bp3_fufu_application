package com.example.fufu.ui.detail_component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.fufu.R
import com.example.fufu.data.model.FoodSearchModel
import com.example.fufu.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle = intent.extras!!
        val foodSearch: FoodSearchModel = bundle.get("foodSearch") as FoodSearchModel
        if (foodSearch != null) {
            binding.itemNameDetail.text = foodSearch.itemName
            binding.itemResDetail.text = foodSearch.resName
            binding.itemDesDetail.text = foodSearch.itemDes
            binding.itemPriceDetail.text = foodSearch.itemPrice.toString()
            Glide.with(this)
                .load("http://192.168.1.122/fufuAPI/images/" + foodSearch.itemImg).into(binding.itemImgDetail)
        } else {
            Toast.makeText(this, "m cut", Toast.LENGTH_SHORT).show()
        }
    }
}