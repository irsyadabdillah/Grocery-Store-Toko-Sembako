package com.irzstudio.foodapp.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irzstudio.foodapp.data.DummyDataSource
import com.irzstudio.foodapp.model.beverages.BeveragesEntity
import io.reactivex.disposables.CompositeDisposable

class ProductViewModel(val dummyDataSource: DummyDataSource): ViewModel() {

    private val _beverages = MutableLiveData<ArrayList<BeveragesEntity>>()
    val beverages: LiveData<ArrayList<BeveragesEntity>> = _beverages

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun showDataBeverages() {
        val beveragesDisposable = dummyDataSource.getBeverages()
            .doOnSubscribe { }
            .doFinally { }
            .subscribe(
                { _beverages.postValue(it) },
                { _errorMessage.postValue(it.localizedMessage) })
        compositeDisposable.add(beveragesDisposable)
    }
}