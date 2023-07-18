package com.example.listroomdb.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FoodItemRepository(private val foodItemDao: FoodItemDao) {

    val allFoodItems:Flow<MutableList<FoodItem>> = foodItemDao.getFoodItems()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(foodItem: FoodItem){
        CoroutineScope(Dispatchers.IO).launch{
            foodItemDao.insert(foodItem)
        }

    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(foodItem: FoodItem){
        CoroutineScope(Dispatchers.IO).launch{
            foodItemDao.delete(foodItem)
        }
    }
}