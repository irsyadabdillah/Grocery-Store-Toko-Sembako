package com.irzstudio.GroceryStore.di

import com.irzstudio.GroceryStore.data.DummyDataSource
import com.irzstudio.GroceryStore.data.Repository
import com.irzstudio.GroceryStore.model.DataBase
import org.koin.dsl.module

val dataModule = module {

    single { DataBase.getInstance() }
    factory { DummyDataSource() }
    single { Repository(get(), get()) }

}