package com.irzstudio.GroceryStore.di

import com.irzstudio.GroceryStore.ui.cart.CartViewModel
import com.irzstudio.GroceryStore.ui.detailproduct.DetailProductViewModel
import com.irzstudio.GroceryStore.ui.explore.ExploreViewModel
import com.irzstudio.GroceryStore.ui.favorite.FavoriteViewModel
import com.irzstudio.GroceryStore.ui.product.ProductViewModel
import com.irzstudio.GroceryStore.ui.shop.ShopViewModel
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