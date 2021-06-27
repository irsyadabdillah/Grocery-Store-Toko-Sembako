package com.irzstudio.GroceryStore.model

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.irzstudio.GroceryStore.AppController
import com.irzstudio.GroceryStore.model.product.ProductEntity
import com.irzstudio.GroceryStore.model.product.ProductDao

@Database(entities = [ProductEntity::class], version = 1)
abstract class DataBase: RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        private var INSTANCE: DataBase? = null

        fun getInstance(): DataBase? {
            if (INSTANCE == null) {
                synchronized(DataBase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        AppController.getInstance().applicationContext,
                        DataBase::class.java, "groceries_stotre.db").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}