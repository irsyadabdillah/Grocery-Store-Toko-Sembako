package com.irzstudio.GroceryStore.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.irzstudio.GroceryStore.R
import com.irzstudio.GroceryStore.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_login_avtivity.*

class LoginAvtivity : AppCompatActivity() {

    private val sharedPref: PreferencesHelper by lazy {
        PreferencesHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_avtivity)

        loginOrSignIn()
        navigationToRegistrasi()

    }

    private fun loginOrSignIn() {
        btn_sign_in.setOnClickListener {
            when {
                et_email_login.text.isEmpty() -> {
                    et_email_login.error = null
                    et_email_login.requestFocus()
                    Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show()
                }
                et_pass_login.text.isEmpty() -> {
                    et_pass_login.error = null
                    et_pass_login.requestFocus()
                    Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                }
            }
        }
    }

    private fun navigationToRegistrasi() {
        tv_sign_up.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }
}





