package com.example.converter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val distanceCard: CardView = findViewById(R.id.distance)
        val areaCard: CardView = findViewById(R.id.area)
        val volumeCard: CardView = findViewById(R.id.volume)
        val weightCard: CardView = findViewById(R.id.weight)
        val temperatureCard: CardView = findViewById(R.id.temperature)
        val currencyCard: CardView = findViewById(R.id.currency)
        distanceCard.setOnClickListener{
            startActivity(Intent(this,Distance::class.java))
        }
        areaCard.setOnClickListener{
            startActivity(Intent(this,Area::class.java))
        }
        volumeCard.setOnClickListener{
            startActivity(Intent(this,Volume::class.java))
        }
        weightCard.setOnClickListener{
            startActivity(Intent(this,Weight::class.java))
        }
        temperatureCard.setOnClickListener{
            startActivity(Intent(this,Temperature::class.java))
        }
        currencyCard.setOnClickListener{
            startActivity(Intent(this,Currency::class.java))
        }
    }
}