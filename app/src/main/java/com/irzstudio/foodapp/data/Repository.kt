package com.irzstudio.foodapp.data

import com.irzstudio.foodapp.model.DataBase
import com.irzstudio.foodapp.model.product.ProductEntity

class Repository(val dummyDataSource: DummyDataSource, val dataBase: DataBase) {

    fun getExclusive() = dummyDataSource.getExclusive()
    fun getGroceries() = dummyDataSource.getGroceries()
    fun getBestSelling() = dummyDataSource.getBestSelling()
    fun getBeverages() = dummyDataSource.getBeverages()
    fun getSearchData() = dummyDataSource.getSearchData("")

    fun saveProduct(productEntity: ProductEntity) {
        dataBase.productDao().insert(productEntity)
    }

    fun removeProduct(id: Int) {
        dataBase.productDao().deleteById(id)
    }

    fun checkProduct(id: Int): Boolean {
        val isFavorited = dataBase.productDao().getById(id)?.size != 0
        return isFavorited
    }

    fun getAllDb(): List<ProductEntity> {
        val dataFromDb = dataBase.productDao().getAll().orEmpty()
        return dataFromDb
    }
}
