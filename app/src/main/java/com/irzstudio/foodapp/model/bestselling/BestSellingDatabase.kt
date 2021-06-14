package com.irzstudio.foodapp.model.bestselling

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.irzstudio.foodapp.AppController
import com.irzstudio.foodapp.model.exclusiveoffer.ExclusiveOfferDao
import com.irzstudio.foodapp.model.exclusiveoffer.ExclusiveOfferDatabase
import com.irzstudio.foodapp.model.exclusiveoffer.ExclusiveOfferEntity

@Database(entities = [BestSellingEntity::class], version = 1)
abstract class BestSellingDatabase: RoomDatabase() {

    abstract fun bestSellingDao(): BestSellingDao

    companion object {
        private var INSTANCE: BestSellingDatabase? = null

        fun getInstance(): BestSellingDatabase? {
            if (INSTANCE == null) {
                synchronized(ExclusiveOfferDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        AppController.getInstance().applicationContext,
                        BestSellingDatabase::class.java, "bestsellingdata.db").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}