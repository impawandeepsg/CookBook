package com.example.cookbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MealCategoriesActivity : AppCompatActivity() {
    private lateinit var viewModel: MealViewModel
    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_categories)

        viewModel = ViewModelProvider(this).get(MealViewModel::class.java)
        categoriesAdapter = CategoriesAdapter()

        val recyclerView: RecyclerView = findViewById(R.id.categoriesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = categoriesAdapter

        viewModel.getMealCategories()
        viewModel.mealCategories.observe(this, Observer { categories ->
            categoriesAdapter.submitList(categories)
        })
    }
}
