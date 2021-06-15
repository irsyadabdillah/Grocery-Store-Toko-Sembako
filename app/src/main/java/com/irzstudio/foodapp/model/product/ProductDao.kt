package com.irzstudio.foodapp.model.product

import androidx.room.*

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll():List<ProductEntity>
    @Insert
    fun insert(productEntity: ProductEntity)

    @Delete
    fun delete(productEntity: ProductEntity)

    @Query("DELETE FROM product WHERE id = :id")
    fun deleteById(id: Int)

    @Update
    fun update(productEntity: ProductEntity)

    @Query("SELECT * From product Where id = :id")
    fun getById(id: Int): List<ProductEntity>
}