package com.irzstudio.foodapp.model.product

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey
    @ColumnInfo(name="id")
    val id: Int = 0,
    @ColumnInfo(name= "name")
    val name: String = "",
    @ColumnInfo(name= "picture")
    val picture: Int = 0,
    @ColumnInfo(name= "description")
    val description: String = "",
    @ColumnInfo(name= "price")
    val price: Long = 0L,
    @ColumnInfo(name= "qty")
    val qty: Int = 0

): Parcelable
