// Repository.kt
package com.example.cookbook

class Repository(private val apiService: ApiService) {
    suspend fun searchMealsByName(name: String): List<Meal> {
        val response = apiService.searchMealByName(name)
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }

    suspend fun getMealsByFirstLetter(): List<Meal> {
        val mealsList = mutableListOf<Meal>()
        for (letter in 'A'..'Z') {
            val response = apiService.searchMealByFirstLetter(letter)
            if (response.isSuccessful) {
                val meals = response.body() ?: emptyList()
                mealsList.addAll(meals)
            }
        }
        return mealsList
    }

    suspend fun getMealCategories(): List<Category> {
        val response = apiService.getMealCategories()
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }
}