package com.irzstudio.foodapp.ui.detailproduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.model.product.ProductEntity
import com.irzstudio.foodapp.utill.Constant
import kotlinx.android.synthetic.main.activity_detail_product.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailProductActivity : AppCompatActivity() {

    private val viewModel: DetailProductViewModel by viewModel()

    private val product by lazy {
        intent.getParcelableExtra<ProductEntity>(Constant.DATA)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        observeIsFavorited()
        loadDataDetail(product!!)
    }


    private fun loadDataDetail(productEntity: ProductEntity) {
        Glide.with(this).load(productEntity.picture)
            .transition(DrawableTransitionOptions.withCrossFade()).into(iv_picture_detail)
        tv_name_detail.text = productEntity.name
        tv_description_detail.text = productEntity.description
        tv_price_detail.text = productEntity.price.toString()
        tv_value_detail.text = productEntity.qty.toString()
    }

    private fun observeIsFavorited() {
        viewModel.isFavorited.observe(this, {
            btn_favorite.isChecked = it
            addFavoriteMovie()
        })
    }

    private fun addFavoriteMovie(){
        btn_favorite.setOnCheckedChangeListener { checkBox, isChecked ->
            if (isChecked){
                viewModel.saveProduct(product!!)
                Toast.makeText(this, "Product added to favorite", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.removeProduct(product!!)
                Toast.makeText(this, "Product removed from favorite", Toast.LENGTH_SHORT).show()
            }
        }
    }

}