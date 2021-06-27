package com.irzstudio.GroceryStore.ui.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irzstudio.GroceryStore.data.Repository
import com.irzstudio.GroceryStore.model.product.ProductEntity
import com.irzstudio.GroceryStore.model.groceries.GroceriesData
import io.reactivex.disposables.CompositeDisposable

class ShopViewModel(val repository : Repository) : ViewModel() {

    private val _exclusiveOffer = MutableLiveData<ArrayList<ProductEntity>>()
    val exclusiveOffer: LiveData<ArrayList<ProductEntity>> = _exclusiveOffer

    private val _bestsSelling = MutableLiveData<ArrayList<ProductEntity>>()
    val bestsSelling: LiveData<ArrayList<ProductEntity>> = _bestsSelling

    private val _groceries = MutableLiveData<ArrayList<GroceriesData>>()
    val groceries: LiveData<ArrayList<GroceriesData>> = _groceries

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }


    fun showDataExclusiveOffer() {
        val exclusiveOfferDisposable = repository.getExclusive()
            .doOnSubscribe { }
            .doFinally { }
            .subscribe(
                { _exclusiveOffer.postValue(it) },
                { _errorMessage.postValue(it.localizedMessage) })
        compositeDisposable.add(exclusiveOfferDisposable)
    }

    fun showDataGroceries() {
        val exclusiveOfferDisposable = repository.getGroceries()
            .doOnSubscribe { }
            .doFinally { }
            .subscribe(
                { _groceries.postValue(it) },
                { _errorMessage.postValue(it.localizedMessage) })
        compositeDisposable.add(exclusiveOfferDisposable)
    }

    fun showDataBestSelling() {
        val bestSellingDisposable = repository.getBestSelling()
            .doOnSubscribe { }
            .doFinally { }
            .subscribe({ _bestsSelling.postValue(it) },
            { _errorMessage.postValue(it.localizedMessage)})
        compositeDisposable.add(bestSellingDisposable)
    }

    fun addToCahar(productEntity: ProductEntity, cart: Int) {
        repository.addToCart(productEntity)
    }


}