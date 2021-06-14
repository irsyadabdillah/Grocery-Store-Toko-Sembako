package com.irzstudio.foodapp.model.exclusiveoffer

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.irzstudio.foodapp.AppController

@Database(entities = [ExclusiveOfferEntity::class], version = 1)
abstract class ExclusiveOfferDatabase : RoomDatabase() {

    abstract fun exclusiveOfferDao(): ExclusiveOfferDao

    companion object {
        private var INSTANCE: ExclusiveOfferDatabase? = null

        fun getInstance(): ExclusiveOfferDatabase? {
            if (INSTANCE == null) {
                synchronized(ExclusiveOfferDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        AppController.getInstance().applicationContext,
                        ExclusiveOfferDatabase::class.java, "exclusifofferdata.db").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}