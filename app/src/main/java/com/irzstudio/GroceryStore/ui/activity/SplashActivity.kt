package com.irzstudio.GroceryStore.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.irzstudio.GroceryStore.R
import com.irzstudio.GroceryStore.utill.Constant

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(applicationContext, GetStartedActivity::class.java))
            finish()
        }, Constant.SPLASH_SCREEN)
    }
}
