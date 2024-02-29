package com.example.cookbook

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
        // Define the base URL
        companion object {
            const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
        }

    @GET("search.php")
    suspend fun searchMealByName(@Query("s") name: String): Response<List<Meal>>

    @GET("search.php")
    suspend fun searchMealByFirstLetter(@Query("f") letter: Char): Response<List<Meal>>

    @GET("categories.php")
    suspend fun getMealCategories(): Response<List<Category>>
}
