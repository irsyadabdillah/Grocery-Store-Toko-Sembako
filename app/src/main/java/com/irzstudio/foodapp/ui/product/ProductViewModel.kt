package com.irzstudio.foodapp.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irzstudio.foodapp.data.Repository
import com.irzstudio.foodapp.model.product.ProductEntity
import io.reactivex.disposables.CompositeDisposable

class ProductViewModel(val repository : Repository): ViewModel() {

    private val _beverages = MutableLiveData<ArrayList<ProductEntity>>()
    val beverages: LiveData<ArrayList<ProductEntity>> = _beverages

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun showDataBeverages() {
        val beveragesDisposable = repository.getBeverages()
            .doOnSubscribe { }
            .doFinally { }
            .subscribe(
                { _beverages.postValue(it) },
                { _errorMessage.postValue(it.localizedMessage) })
        compositeDisposable.add(beveragesDisposable)
    }
}