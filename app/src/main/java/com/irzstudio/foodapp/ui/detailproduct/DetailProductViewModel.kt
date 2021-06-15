package com.irzstudio.foodapp.ui.detailproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irzstudio.foodapp.data.Repository
import com.irzstudio.foodapp.model.product.ProductEntity
import io.reactivex.disposables.CompositeDisposable

class DetailProductViewModel(val repository: Repository) : ViewModel() {

    private val _detailProduct = MutableLiveData<List<ProductEntity>>()
    val detailProduct: LiveData<List<ProductEntity>> = _detailProduct

    private val _isfavorited = MutableLiveData<Boolean>()
    val isFavorited: LiveData<Boolean> = _isfavorited

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun saveProduct(productEntity: ProductEntity) {
        repository.saveProduct(productEntity)
    }

    fun removeProduct(productEntity: ProductEntity) {
        val detail = productEntity
        repository.removeProduct(productEntity.id)
    }

    fun checkProduct(productEntity: ProductEntity) {
        _isfavorited.postValue(repository.checkProduct(productEntity.id))
    }
}