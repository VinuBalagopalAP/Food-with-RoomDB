package com.example.listroomdb.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodItemDao {

    @Query("SELECT * FROM FoodItem ORDER BY price ASC")
    fun getFoodItems():Flow<MutableList<FoodItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(foodItem: FoodItem)

    @Delete
    fun delete(foodItem: FoodItem)
}