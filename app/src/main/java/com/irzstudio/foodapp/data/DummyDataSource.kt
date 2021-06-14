package com.irzstudio.foodapp.data

import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.model.bestselling.BestSellingEntity
import com.irzstudio.foodapp.model.beverages.BeveragesEntity
import com.irzstudio.foodapp.model.exclusiveoffer.ExclusiveOfferEntity
import com.irzstudio.foodapp.model.groceries.GroceriesData
import io.reactivex.Observable

class DummyDataSource {

    fun getExclusif(): Observable<ArrayList<ExclusiveOfferEntity>> {

        val dummy1 = ExclusiveOfferEntity(name = "Organic Bananas", description = "7pcs, Priceg",
            price = 20.000,
            picture = R.drawable.iv_bananas,
            id = 1
        )
        val dummy2 = ExclusiveOfferEntity(name = "Red Apple", description = "1kg, Priceg",
            price = 15.000,
            picture = R.drawable.iv_apple,
            id = 2
        )
        val dummy3 = ExclusiveOfferEntity(name = "Egg Chicken Red", description = "4pcs, Priceg",
            price = 8.000,
            picture = R.drawable.iv_egg_chicken,
            id = 3
        )
        val dummy4 = ExclusiveOfferEntity(name = "Ginger", description = "250gm, Priceg",
            price = 22.000,
            picture = R.drawable.iv_ginger,
            id = 4
        )

        val data = listOf(dummy1, dummy2, dummy3, dummy4)
        return Observable.just(ArrayList(data))

    }

    fun getBestSelling(): Observable<ArrayList<BestSellingEntity>> {

        val dummy1 = BestSellingEntity(name = "Bell Pepper Red", description = "1kg, Priceg",
            price = 20.000,
            picture = R.drawable.iv_pepper_red,
            id = 1
        )
        val dummy2 = BestSellingEntity(name = "Beef bone", description = "1kg, Priceg",
            price = 25.000,
            picture = R.drawable.iv_beef_bone,
            id = 2
        )
        val dummy3 = BestSellingEntity(name = "Boiler Chicken", description = "1kg, Priceg",
            price = 15.000,
            picture = R.drawable.iv_boiler_chicken,
            id = 3
        )
        val dummy4 = BestSellingEntity(name = "Ginger", description = "250gm, Priceg",
            price = 10.000,
            picture = R.drawable.iv_ginger,
            id = 4
        )

        val data = listOf(dummy1, dummy2, dummy3, dummy4)
        return Observable.just(ArrayList(data))
    }

    fun getGroceries(): Observable<ArrayList<GroceriesData>> {

        val dummy1 = GroceriesData("Beverages", R.drawable.iv_beverages)
        val dummy2 = GroceriesData("Fruits & Vegetable", R.drawable.iv_fruits_vagetable)
        val dummy3 = GroceriesData("Rices", R.drawable.iv_rice)
        val dummy4 = GroceriesData("Dairy & Eggs", R.drawable.iv_dairy_eggs)

        val data = listOf(dummy1, dummy2, dummy3, dummy4)
        return Observable.just(ArrayList(data))
    }

    fun getBeverages(): Observable<ArrayList<BeveragesEntity>> {

        val dummy1 = BeveragesEntity(name = "Diet Coke", description = "335ml, Price",
            price = 8.000,
            picture = R.drawable.iv_coke,
            id = 1
        )

        val dummy2 = BeveragesEntity(name = "Sprite Can", description = "325ml, Price",
            price = 8.000,
            picture = R.drawable.iv_sprite,
            id = 1
        )

        val dummy3 = BeveragesEntity(name = "Apple $ Grape Juice", description = "2L, Price",
            price = 20.000,
            picture = R.drawable.iv_juice_apple_grape,
            id = 1
        )

        val dummy4 = BeveragesEntity(name = "Orange Juice", description = "2L, Price",
            price = 20.000,
            picture = R.drawable.iv_juice_orange,
            id = 1
        )

        val dummy5 = BeveragesEntity(name = "Coca Cola Can", description = "325ml, Price",
            price = 10.000,
            picture = R.drawable.iv_cocacola,
            id = 1
        )

        val dummy6 = BeveragesEntity(name = "Pepsi Can", description = "330ml, Price",
            price = 10.000,
            picture = R.drawable.iv_pepsi,
            id = 1
        )

        val data = listOf(dummy1, dummy2, dummy3, dummy4, dummy5, dummy6)
        return Observable.just(ArrayList(data))
    }

}