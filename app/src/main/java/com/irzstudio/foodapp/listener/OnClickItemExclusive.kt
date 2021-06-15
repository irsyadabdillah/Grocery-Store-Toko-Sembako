package com.irzstudio.foodapp.listener

import com.irzstudio.foodapp.model.product.ProductEntity

interface OnClickItemExclusive {
    fun onClick(productEntity: ProductEntity)
}