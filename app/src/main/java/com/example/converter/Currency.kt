package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Currency : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)
        supportActionBar?.title = "Currency"

    }
}