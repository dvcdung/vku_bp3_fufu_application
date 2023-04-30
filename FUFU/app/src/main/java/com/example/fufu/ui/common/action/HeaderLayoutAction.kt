package com.example.fufu.ui.common.action;

import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.fufu.R

public class HeaderLayoutAction(activity: AppCompatActivity) {
    private val backButton: ImageButton = activity.findViewById(R.id.btn_back)

    init {
        backButton.setOnClickListener {
            activity.onBackPressed()
        }
    }
}
