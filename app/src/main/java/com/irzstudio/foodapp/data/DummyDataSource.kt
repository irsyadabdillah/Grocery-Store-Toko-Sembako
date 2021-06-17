package com.irzstudio.foodapp.data

import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.model.product.ProductEntity
import com.irzstudio.foodapp.model.groceries.GroceriesData
import io.reactivex.Observable

class DummyDataSource {

    fun getExclusive(): Observable<ArrayList<ProductEntity>> {

        val dummy1 = ProductEntity(name = "Organic Bananas", description = "7pcs, Priceg",
            price = 20000,
            picture = R.drawable.iv_bananas,
            id = 1
        )
        val dummy2 = ProductEntity(name = "Red Apple", description = "1kg, Priceg",
            price = 15000,
            picture = R.drawable.iv_apple,
            id = 2
        )
        val dummy3 = ProductEntity(name = "Egg Chicken Red", description = "4pcs, Priceg",
            price = 8000,
            picture = R.drawable.iv_egg_chicken,
            id = 3
        )
        val dummy4 = ProductEntity(name = "Ginger", description = "250gm, Priceg",
            price = 22000,
            picture = R.drawable.iv_ginger,
            id = 4
        )

        val data = listOf(dummy1, dummy2, dummy3, dummy4)
        return Observable.just(ArrayList(data))

    }

    fun getBestSelling(): Observable<ArrayList<ProductEntity>> {

        val dummy1 = ProductEntity(name = "Bell Pepper Red", description = "1kg, Priceg",
            price = 20000,
            picture = R.drawable.iv_pepper_red,
            id = 5
        )
        val dummy2 = ProductEntity(name = "Beef bone", description = "1kg, Priceg",
            price = 25000,
            picture = R.drawable.iv_beef_bone,
            id = 6
        )
        val dummy3 = ProductEntity(name = "Boiler Chicken", description = "1kg, Priceg",
            price = 15000,
            picture = R.drawable.iv_boiler_chicken,
            id = 7
        )
        val dummy4 = ProductEntity(name = "Ginger", description = "250gm, Priceg",
            price = 22000,
            picture = R.drawable.iv_ginger,
            id = 4
        )

        val data = listOf(dummy1, dummy2, dummy3, dummy4)
        return Observable.just(ArrayList(data))
    }

    fun getGroceries(): Observable<ArrayList<GroceriesData>> {

        val dummy1 = GroceriesData(name="Beverages", picture = R.drawable.iv_beverages )
        val dummy2 = GroceriesData(name= "Fruits & Vegetable", picture = R.drawable.iv_fruits_vagetable)
        val dummy3 = GroceriesData(name = "Rices", picture = R.drawable.iv_rice)
        val dummy4 = GroceriesData(name = "Dairy & Eggs", picture = R.drawable.iv_dairy_eggs)

        val data = listOf(dummy1, dummy2, dummy3, dummy4)
        return Observable.just(ArrayList(data))
    }

    fun getBeverages(): Observable<ArrayList<ProductEntity>> {

        val dummy1 = ProductEntity(name = "Diet Coke", description = "335ml, Price",
            price = 8000,
            picture = R.drawable.iv_coke,
            id = 8
        )

        val dummy2 = ProductEntity(name = "Sprite Can", description = "325ml, Price",
            price = 8000,
            picture = R.drawable.iv_sprite,
            id = 9
        )

        val dummy3 = ProductEntity(name = "Apple & Grape Juice", description = "2L, Price",
            price = 20000,
            picture = R.drawable.iv_juice_apple_grape,
            id = 10
        )

        val dummy4 = ProductEntity(name = "Orange Juice", description = "2L, Price",
            price = 20000,
            picture = R.drawable.iv_juice_orange,
            id = 11
        )

        val dummy5 = ProductEntity(name = "Coca Cola Can", description = "325ml, Price",
            price = 10000,
            picture = R.drawable.iv_cocacola,
            id = 12
        )

        val dummy6 = ProductEntity(name = "Pepsi Can", description = "330ml, Price",
            price = 10000,
            picture = R.drawable.iv_pepsi,
            id = 13
        )

        val data = listOf(dummy1, dummy2, dummy3, dummy4, dummy5, dummy6)
        return Observable.just(ArrayList(data))
    }

    fun getSearchData(qword: String?): Observable<List<ProductEntity>> {
        val listData = listOf(getBestSelling(), getExclusive(),getBeverages())
        val resultData = mutableListOf<ProductEntity>()

        return Observable.merge(listData).doOnNext{
            resultData.addAll(it)
        }
            .map {
                return@map resultData.filter {
                    it.name.contains(qword.orEmpty(), true)
                }
            }
    }

}