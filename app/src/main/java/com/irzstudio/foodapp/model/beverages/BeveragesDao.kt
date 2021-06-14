package com.irzstudio.foodapp.model.beverages

import androidx.room.*

@Dao
interface BeveragesDao {
    @Query("SELECT * FROM beverages")
    fun getAll():List<BeveragesEntity>
    @Insert
    fun insert(bestSellingEntity: BeveragesEntity)

    @Delete
    fun delete(bestSellingEntity: BeveragesEntity)

    @Query("DELETE FROM beverages WHERE id = :id")
    fun deleteById(id: Int)

    @Update
    fun update(bestSellingEntity: BeveragesEntity)

    @Query("SELECT * From beverages Where id = :id")
    fun getById(id: Int): List<BeveragesEntity>
}