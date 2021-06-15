package com.irzstudio.foodapp.di

import com.irzstudio.foodapp.data.DummyDataSource
import com.irzstudio.foodapp.data.Repository
import com.irzstudio.foodapp.model.DataBase
import org.koin.dsl.module

val dataModule = module {

    single { DataBase.getInstance() }
    factory { DummyDataSource() }
    single { Repository(get(), get()) }

}