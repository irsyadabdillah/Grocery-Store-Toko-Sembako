package com.irzstudio.GroceryStore.data

import com.irzstudio.GroceryStore.model.DataBase
import com.irzstudio.GroceryStore.model.product.ProductEntity
import com.irzstudio.GroceryStore.utill.ProductSavedType

class Repository(val dummyDataSource: DummyDataSource, val dataBase: DataBase) {

    fun getExclusive() = dummyDataSource.getExclusive()
    fun getGroceries() = dummyDataSource.getGroceries()
    fun getBestSelling() = dummyDataSource.getBestSelling()
    fun getBeverages() = dummyDataSource.getBeverages()
    fun getSearchData(qword: String?) = dummyDataSource.getSearchData(qword)

    fun addToFav(productEntity: ProductEntity) {
        val prod = productEntity.copy(type = ProductSavedType.FAV)
        dataBase.productDao().insert(prod)
    }

    fun addToCart(productEntity: ProductEntity, qty: Int = 1 ) {
        val prodList = dataBase.productDao().getById(productEntity.id, ProductSavedType.CART)
        if (prodList.isNotEmpty()) {
            val prod = prodList[0].copy(
                qty = prodList[0].qty + qty,
                type = ProductSavedType.CART
            )
            dataBase.productDao().delete(productEntity)
            dataBase.productDao().insert(prod)
        } else {
            val prod = productEntity.copy(
                qty = qty,
                type = ProductSavedType.CART
            )
            dataBase.productDao().insert(prod)

        }
    }

    fun subtractCart(productEntity: ProductEntity, qty: Int = 1) {
        if (productEntity.qty > 1) {
            val prod = productEntity.copy(
                qty = productEntity.qty - qty,
            )
            dataBase.productDao().delete(productEntity)
            dataBase.productDao().insert(prod)
        } else {
            dataBase.productDao().delete(productEntity)
        }
    }


    fun removeProductFav(id: Int, type: Int) {
        dataBase.productDao().deleteById(id, ProductSavedType.FAV)
    }

    fun removeProductCart(id: Int, type: Int) {
        dataBase.productDao().deleteById(id, ProductSavedType.CART)
    }

    fun checkProduct(id: Int): Boolean {
        val isFavorited = dataBase.productDao().getById(id, ProductSavedType.FAV).size != 0
        return isFavorited
    }

    fun getAllDb(type: Int): List<ProductEntity> {
        val dataFromDb = dataBase.productDao().getAll(type).orEmpty()
        return dataFromDb
    }

}
