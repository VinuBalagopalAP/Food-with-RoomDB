package com.example.listroomdb.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodItemDao {

    @Query("SELECT * FROM FoodItem ORDER BY name")
    fun getFoodItems():Flow<MutableList<FoodItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(foodItem: FoodItem)

    @Delete
    suspend fun delete(foodItem: FoodItem)
}