package com.example.cookbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aboutTextView: TextView = findViewById(R.id.aboutTextView)
        aboutTextView.text = getString(R.string.about_text) + "\n\nDeveloped by:\n1. Pawandeep Singh\n2. Ashish Sharma\n3. Srenezaa Parasharamatam"
    }
}