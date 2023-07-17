package com.example.listroomdb.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="FoodItem")
data class FoodItem(
    @PrimaryKey @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Float
    )