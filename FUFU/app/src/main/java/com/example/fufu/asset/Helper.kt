package com.example.fufu.asset

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext

class Helper {
    private lateinit var sharePref: SharedPreferences

    fun checkUserRole(context: Context): Boolean {
        sharePref = context.getSharedPreferences("currentUser", AppCompatActivity.MODE_PRIVATE)
        return (sharePref.getString("userRole", null) == "1")
    }

    fun getCurrentUser(context: Context): String? {
        sharePref = context.getSharedPreferences("currentUser", AppCompatActivity.MODE_PRIVATE)
        return sharePref.getString("userId", null)
    }
}
