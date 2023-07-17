package com.example.listroomdb

import android.app.Application
import com.example.listroomdb.data.FoodItemRepository
import com.example.listroomdb.data.FoodItemRoomDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApplication : Application() {

    // No need to cancel this scope as it'll be torn down with the process
    private val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    private val database by lazy {
        FoodItemRoomDB.getDatabase(this,applicationScope)
    }

    val repository by lazy {
        FoodItemRepository(database.foodItemDao())
    }

}