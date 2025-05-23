package com.com.dica.bookmarks.ui.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }
    var text: Boolean
        get() = sharedPreferences.getBoolean("text", true)
        set(value) = sharedPreferences.edit().putBoolean("text", value).apply()

    var layoutManager: Boolean
        get() = sharedPreferences.getBoolean("text", true)
        set(value) = sharedPreferences.edit().putBoolean("text", value).apply()

    fun setOnBoardingCompleted(completed: Boolean) {
        sharedPreferences.edit().putBoolean("onBoardingCompleted", completed).apply()
    }

    fun isOnBoardingCompleted(): Boolean {
        return sharedPreferences.getBoolean("onBoardingCompleted", true)
    }
    fun isLinearLayout(): Boolean {
        return sharedPreferences.getBoolean("isLinearLayout", true)
    }
    fun setLinearLayout(isLinearLayout: Boolean) {
        sharedPreferences.edit().putBoolean("isLinearLayout", isLinearLayout).apply()
    }
    fun setRegistered(isRegistered: Boolean) {
        sharedPreferences.edit().putBoolean("isRegistered", isRegistered).apply()
    }
    fun isRegistered(): Boolean {
        return sharedPreferences.getBoolean("isRegistered", false)
    }
}