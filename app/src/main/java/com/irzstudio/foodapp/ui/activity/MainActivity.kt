package com.irzstudio.foodapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.ui.account.AccountFragment
import com.irzstudio.foodapp.ui.cart.CartFragment
import com.irzstudio.foodapp.ui.explore.ExploreFragment
import com.irzstudio.foodapp.ui.favorite.FavoriteFragment
import com.irzstudio.foodapp.ui.shop.ShopFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shopFragment()
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        bottom_nav_bar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.shop -> shopFragment()
                R.id.explore -> exploreFragment()
                R.id.cart -> cartFragment()
                R.id.favorite -> favoriteFragment()
                R.id.account -> accountFragment()
            }
            true
        }
    }

    private fun shopFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, ShopFragment()).commit()
    }
    private fun exploreFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, ExploreFragment()).commit()
    }
    private fun cartFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, CartFragment()).commit()
    }
    private fun favoriteFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, FavoriteFragment()).commit()
    }
    private fun accountFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, AccountFragment()).commit()
    }

    fun navigateExplore(){
        bottom_nav_bar.selectedItemId = R.id.explore
    }

}