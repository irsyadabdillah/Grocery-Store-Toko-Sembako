package com.irzstudio.foodapp.di

import com.irzstudio.foodapp.data.DummyDataSource
import com.irzstudio.foodapp.model.bestselling.BestSellingDatabase
import com.irzstudio.foodapp.model.exclusiveoffer.ExclusiveOfferDatabase
import org.koin.dsl.module

val dataModule = module {

    single { ExclusiveOfferDatabase.getInstance() }
    single { BestSellingDatabase.getInstance() }
    factory { DummyDataSource() }

}