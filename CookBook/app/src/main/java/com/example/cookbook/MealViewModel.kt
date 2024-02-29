package com.example.cookbook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MealViewModel(private val repository: Repository) : ViewModel() {
    private val _searchResults = MutableLiveData<List<Meal>>()
    val searchResults: LiveData<List<Meal>> = _searchResults

    private val _mealCategories = MutableLiveData<List<Category>>()
    val mealCategories: LiveData<List<Category>> = _mealCategories

    fun searchMealsByName(name: String) {
        viewModelScope.launch {
            val meals = repository.searchMealsByName(name)
            _searchResults.value = meals
        }
    }

    fun getMealsByFirstLetter() {
        viewModelScope.launch {
            val meals = repository.getMealsByFirstLetter()
            _searchResults.value = meals
        }
    }

    fun getMealCategories() {
        viewModelScope.launch {
            val categories = repository.getMealCategories()
            _mealCategories.value = categories
        }
    }
}
