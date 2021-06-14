package com.irzstudio.foodapp.listener

import com.irzstudio.foodapp.model.bestselling.BestSellingEntity

interface OnClickItemBestSelling {
    fun onClick(bestSellingEntity: BestSellingEntity)
}