package com.irzstudio.GroceryStore.model.product

import androidx.room.*

@Dao
interface ProductDao {
    @Query("SELECT * FROM product WHERE type = :type")
    fun getAll(type: Int):List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(productEntity: ProductEntity)

    @Delete
    fun delete(productEntity: ProductEntity)

    /*@Query("DELETE FROM product")
    fun delete(productEntity: Int, type: Int)*/

    @Query("DELETE FROM product WHERE id = :id AND type = :type")
    fun deleteById(id: Int, type:Int)

    @Update
    fun update(productEntity: ProductEntity)

    @Query("SELECT * From product Where id = :id AND type = :type")
    fun getById(id: Int, type: Int): List<ProductEntity>
}