package com.irzstudio.foodapp.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irzstudio.foodapp.data.Repository
import com.irzstudio.foodapp.model.product.ProductEntity
import com.irzstudio.foodapp.utill.ProductSavedType

class FavoriteViewModel(val repository : Repository): ViewModel() {

    private val _favoriteProduct = MutableLiveData<ArrayList<ProductEntity>>()
    val favoriteProduct: LiveData<ArrayList<ProductEntity>> = _favoriteProduct

    private var dataFavorite: ArrayList<ProductEntity> = ArrayList()

    fun loadDataFavorite() {
        dataFavorite.clear()
        dataFavorite.addAll(repository.getAllDb(ProductSavedType.FAV))
        _favoriteProduct.postValue(dataFavorite)
    }

}