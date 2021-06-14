package com.irzstudio.foodapp.ui.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irzstudio.foodapp.data.DummyDataSource
import com.irzstudio.foodapp.model.bestselling.BestSellingEntity
import com.irzstudio.foodapp.model.exclusiveoffer.ExclusiveOfferEntity
import com.irzstudio.foodapp.model.groceries.GroceriesData
import io.reactivex.disposables.CompositeDisposable

class ShopViewModel(val dummyDataSource: DummyDataSource) : ViewModel() {

    private val _exclusiveOffer = MutableLiveData<ArrayList<ExclusiveOfferEntity>>()
    val exclusiveOffer: LiveData<ArrayList<ExclusiveOfferEntity>> = _exclusiveOffer

    private val _groceries = MutableLiveData<ArrayList<GroceriesData>>()
    val groceries: LiveData<ArrayList<GroceriesData>> = _groceries

    private val _bestsSelling = MutableLiveData<ArrayList<BestSellingEntity>>()
    val bestsSelling: LiveData<ArrayList<BestSellingEntity>> = _bestsSelling

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }


    fun showDataExclusiveOffer() {
        val exclusiveOfferDisposable = dummyDataSource.getExclusif()
            .doOnSubscribe { }
            .doFinally { }
            .subscribe(
                { _exclusiveOffer.postValue(it) },
                { _errorMessage.postValue(it.localizedMessage) })
        compositeDisposable.add(exclusiveOfferDisposable)
    }

    fun showDataGroceries() {
        val exclusiveOfferDisposable = dummyDataSource.getGroceries()
            .doOnSubscribe { }
            .doFinally { }
            .subscribe(
                { _groceries.postValue(it) },
                { _errorMessage.postValue(it.localizedMessage) })
        compositeDisposable.add(exclusiveOfferDisposable)
    }

    fun showDataBestSelling() {
        val bestSellingDisposable = dummyDataSource.getBestSelling()
            .doOnSubscribe { }
            .doFinally { }
            .subscribe({ _bestsSelling.postValue(it) },
            { _errorMessage.postValue(it.localizedMessage)})
        compositeDisposable.add(bestSellingDisposable)
    }

}