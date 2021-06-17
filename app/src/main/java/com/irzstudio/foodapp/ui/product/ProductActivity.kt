package com.irzstudio.foodapp.ui.product

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.adapter.BeveragesAdapter
import com.irzstudio.foodapp.listener.OnClickItem
import com.irzstudio.foodapp.listener.OnClickItemAndAdd
import com.irzstudio.foodapp.model.product.ProductEntity
import com.irzstudio.foodapp.ui.activity.MainActivity
import com.irzstudio.foodapp.ui.detailproduct.DetailProductActivity
import com.irzstudio.foodapp.utill.Constant
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
        beveragesAdapter.onClickListener = object : OnClickItemAndAdd {
            override fun onClick(productEntity: ProductEntity) {
                val intent = Intent(this@ProductActivity, DetailProductActivity::class.java)
                intent.putExtra(Constant.DATA, productEntity)
                startActivity(intent)
            }

            override fun onClickAdd(productEntity: ProductEntity) {
                addProductToCart(productEntity)
            }
        }
    }

    private fun backToMainActivity() {
        btn_back.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }

    private fun addProductToCart(productEntity: ProductEntity) {
        if (productEntity.qty == 0) {
            viewModel.addToCahar(productEntity)
            Toast.makeText(applicationContext, "Product added to cart", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.removeProduct(productEntity)
            Toast.makeText(applicationContext, "Product removed from cart", Toast.LENGTH_SHORT).show()
        }
    }
}