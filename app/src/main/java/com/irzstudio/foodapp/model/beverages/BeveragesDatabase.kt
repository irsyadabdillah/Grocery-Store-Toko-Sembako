package com.irzstudio.foodapp.model.beverages

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.irzstudio.foodapp.AppController
import com.irzstudio.foodapp.model.bestselling.BestSellingDao
import com.irzstudio.foodapp.model.bestselling.BestSellingEntity
import com.irzstudio.foodapp.model.exclusiveoffer.ExclusiveOfferDatabase

@Database(entities = [BeveragesEntity::class], version = 1)
abstract class BeveragesDatabase: RoomDatabase() {

    abstract fun beveragesDao(): BeveragesDao

    companion object {
        private var INSTANCE: BeveragesDatabase? = null

        fun getInstance(): BeveragesDatabase? {
            if (INSTANCE == null) {
                synchronized(ExclusiveOfferDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        AppController.getInstance().applicationContext,
                        BeveragesDatabase::class.java, "beveragesdata.db").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}