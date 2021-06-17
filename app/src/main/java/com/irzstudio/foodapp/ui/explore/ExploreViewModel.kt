package com.irzstudio.foodapp.ui.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irzstudio.foodapp.data.Repository
import com.irzstudio.foodapp.model.product.ProductEntity
import com.irzstudio.foodapp.utill.ProductSavedType
import io.reactivex.disposables.CompositeDisposable

class ExploreViewModel(val repository: Repository) : ViewModel() {

    private val _searchProduct = MutableLiveData<List<ProductEntity>>()
    val searchProduct: LiveData<List<ProductEntity>> = _searchProduct

    private val _isAddedToCart = MutableLiveData<Boolean>()
    val isAddedToCart: LiveData<Boolean> = _isAddedToCart

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun requestProductQuery(qword: String?) {
        val productQueryDisposable = repository.getSearchData(qword)
            .doOnSubscribe {  }
            .doFinally {  }
            .subscribe(
                { _searchProduct.postValue(it) },
                { _errorMessage.postValue(it.localizedMessage) })
        compositeDisposable.add(productQueryDisposable)
    }

    fun addToCahar(productEntity: ProductEntity) {
        repository.addToCart(productEntity)
    }

    fun removeProductCart(productEntity: ProductEntity) {
        repository.removeProductCart(productEntity.id, ProductSavedType.CART)
    }
}