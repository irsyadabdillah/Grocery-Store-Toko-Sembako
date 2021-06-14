package com.irzstudio.foodapp.model.exclusiveoffer

import androidx.room.*

@Dao
interface ExclusiveOfferDao {
    @Query("SELECT * FROM exclusive_offer")
    fun getAll():List<ExclusiveOfferEntity>
    @Insert
    fun insert(exclusiveOfferEntity: ExclusiveOfferEntity)

    @Delete
    fun delete(exclusiveOfferEntity: ExclusiveOfferEntity)

    @Query("DELETE FROM exclusive_offer WHERE id = :id")
    fun deleteById(id: Int)

    @Update
    fun update(exclusiveOfferEntity: ExclusiveOfferEntity)

    @Query("SELECT * From exclusive_offer Where id = :id")
    fun getById(id: Int): List<ExclusiveOfferEntity>
}