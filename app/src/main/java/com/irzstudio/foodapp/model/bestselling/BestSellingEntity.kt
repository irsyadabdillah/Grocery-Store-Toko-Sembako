package com.irzstudio.foodapp.model.bestselling

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "best_selling")
data class BestSellingEntity(
    @PrimaryKey
    @ColumnInfo(name="id")
    val id: Int?,
    @ColumnInfo(name= "name")
    val name: String,
    @ColumnInfo(name= "picture")
    val picture: Int,
    @ColumnInfo(name= "description")
    val description: String,
    @ColumnInfo(name= "price")
    val price: Double,
    @ColumnInfo(name= "qty")
    val qty: Int = 0

): Parcelable
