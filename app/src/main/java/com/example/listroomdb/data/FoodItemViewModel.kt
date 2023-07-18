package com.example.listroomdb.data

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class FoodItemViewModel(private val foodItemRepository: FoodItemRepository) : ViewModel() {

    val allFoodItems : LiveData<MutableList<FoodItem>> = foodItemRepository.allFoodItems.asLiveData()

    // Launching a new coroutine to insert the data in a non-blocking way
    fun insert(foodItem: FoodItem) = viewModelScope.launch {
        foodItemRepository.insert(foodItem)
    }

    fun delete(foodItem: FoodItem) = viewModelScope.launch {
        foodItemRepository.delete(foodItem)
    }

    class FoodItemViewModelFactory(private val foodItemRepository: FoodItemRepository)
        :ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FoodItemViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return FoodItemViewModel(foodItemRepository) as T
            }
            throw IllegalArgumentException("Unknown VieModel Class")
        }

    }
}