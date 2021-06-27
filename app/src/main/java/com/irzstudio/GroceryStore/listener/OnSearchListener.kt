package com.irzstudio.GroceryStore.listener

import com.irzstudio.GroceryStore.model.product.ProductEntity

interface OnSearchListener {
    fun onSearch(productEntity: ProductEntity)
}