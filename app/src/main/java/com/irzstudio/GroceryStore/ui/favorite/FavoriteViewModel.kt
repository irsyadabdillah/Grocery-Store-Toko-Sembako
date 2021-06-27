package com.irzstudio.GroceryStore.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irzstudio.GroceryStore.data.Repository
import com.irzstudio.GroceryStore.model.product.ProductEntity
import com.irzstudio.GroceryStore.utill.ProductSavedType

class FavoriteViewModel(val repository : Repository): ViewModel() {

    private val _favoriteProduct = MutableLiveData<ArrayList<ProductEntity>>()
    val favoriteProduct: LiveData<ArrayList<ProductEntity>> = _favoriteProduct

    private var dataFavorite: ArrayList<ProductEntity> = ArrayList()

    fun loadDataFavorite() {
        dataFavorite.clear()
        dataFavorite.addAll(repository.getAllDb(ProductSavedType.FAV))
        _favoriteProduct.postValue(dataFavorite)
    }

    fun removeProduct(pos : Int) {
        val prod = _favoriteProduct.value?.get(pos)
        repository.removeProductFav(prod?.id?: pos, ProductSavedType.FAV)

    }

}