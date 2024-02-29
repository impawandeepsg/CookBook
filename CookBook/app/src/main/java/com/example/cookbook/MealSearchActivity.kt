package com.example.cookbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider

class MealSearchActivity : AppCompatActivity() {
    private lateinit var viewModel: MealViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_search)

        viewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        val searchButton: Button = findViewById(R.id.searchButton)
        searchButton.setOnClickListener {
            val searchEditText: EditText = findViewById(R.id.searchEditText)
            val searchQuery = searchEditText.text.toString()
            viewModel.searchMealsByName(searchQuery)
        }
    }
}
