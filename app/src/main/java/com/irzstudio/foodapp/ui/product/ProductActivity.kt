package com.irzstudio.foodapp.ui.product

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.adapter.BeveragesAdapter
import com.irzstudio.foodapp.ui.activity.MainActivity
import kotlinx.android.synthetic.main.activity_product.*
import org.koin.android.viewmodel.ext.android.viewModel

class ProductActivity : AppCompatActivity() {

    private val beveragesAdapter: BeveragesAdapter by lazy {
        BeveragesAdapter()
    }

    private val viewModel: ProductViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        observeBeverages()
        setListGroceries()
        backToMainActivity()
        viewModel.showDataBeverages()
    }

    private fun observeBeverages() {
        viewModel.beverages.observe(this, {
            beveragesAdapter.setDataAdapter(it)
        })
    }

    private fun setListGroceries() {
        rv_beverages.setHasFixedSize(true)
        rv_beverages.adapter = beveragesAdapter
        rv_beverages.layoutManager = GridLayoutManager(this, 2)
    }

    private fun backToMainActivity() {
        btn_back.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }
}