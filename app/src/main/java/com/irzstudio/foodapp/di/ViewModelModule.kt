package com.irzstudio.foodapp.di

import com.irzstudio.foodapp.data.DummyDataSource
import com.irzstudio.foodapp.ui.cart.CartViewModel
import com.irzstudio.foodapp.ui.detailproduct.DetailProductViewModel
import com.irzstudio.foodapp.ui.explore.ExploreViewModel
import com.irzstudio.foodapp.ui.favorite.FavoriteViewModel
import com.irzstudio.foodapp.ui.product.ProductActivity
import com.irzstudio.foodapp.ui.product.ProductViewModel
import com.irzstudio.foodapp.ui.shop.ShopViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ShopViewModel(get()) }
    viewModel { ProductViewModel(get()) }
    viewModel { DetailProductViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { ExploreViewModel(get()) }
    viewModel { CartViewModel(get()) }
}