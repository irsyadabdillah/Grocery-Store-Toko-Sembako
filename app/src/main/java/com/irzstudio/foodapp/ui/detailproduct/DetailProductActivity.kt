package com.irzstudio.foodapp.ui.detailproduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.utill.Constant

class DetailProductActivity : AppCompatActivity() {

    private val id: Int by lazy {
        intent.getIntExtra(Constant.ID, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)


    }
}