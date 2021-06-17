package com.irzstudio.foodapp.listener

import com.irzstudio.foodapp.model.product.ProductEntity

interface OnSearchListener {
    fun onSearch(productEntity: ProductEntity)
}