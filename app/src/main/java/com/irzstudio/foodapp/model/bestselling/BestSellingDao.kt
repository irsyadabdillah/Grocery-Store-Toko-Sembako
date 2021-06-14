package com.irzstudio.foodapp.model.bestselling

import androidx.room.*
import com.irzstudio.foodapp.model.exclusiveoffer.ExclusiveOfferEntity

@Dao
interface BestSellingDao {
    @Query("SELECT * FROM best_selling")
    fun getAll():List<BestSellingEntity>
    @Insert
    fun insert(bestSellingEntity: BestSellingEntity)

    @Delete
    fun delete(bestSellingEntity: BestSellingEntity)

    @Query("DELETE FROM best_selling WHERE id = :id")
    fun deleteById(id: Int)

    @Update
    fun update(bestSellingEntity: BestSellingEntity)

    @Query("SELECT * From best_selling Where id = :id")
    fun getById(id: Int): List<BestSellingEntity>
}