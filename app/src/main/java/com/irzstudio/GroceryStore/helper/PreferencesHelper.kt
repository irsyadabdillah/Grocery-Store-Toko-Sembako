package com.irzstudio.GroceryStore.helper

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper (context: Context) {

    private val login = "login"
    private val PREF_NAME = "sharedpreslogin"
    private var sharedPref: SharedPreferences
    val editor: SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put (key: String, value: String){
        editor.putString(key, value).apply()
    }

    fun getString(key: String): String?{
        return sharedPref.getString(key, null)
    }

    fun put (key: String, value: Boolean){
        editor.putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPref.getBoolean(key, false)
    }

    fun getStatus(): Boolean {
        return sharedPref.getBoolean(login, false)
    }

    fun clearAll(){
        editor.clear().apply()
    }
}