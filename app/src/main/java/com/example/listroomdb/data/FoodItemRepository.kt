package com.example.listroomdb.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class FoodItemRepository(private val foodItemDao: FoodItemDao) {

    val alFoodItems:Flow<MutableList<FoodItem>> = foodItemDao.getFoodItems()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(foodItem: FoodItem){
        foodItemDao.insert(foodItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(foodItem: FoodItem){
        foodItemDao.delete(foodItem)
    }

}