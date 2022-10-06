package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class Distance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distance)
        supportActionBar?.title = "Distance"
        val convertButton:Button = findViewById(R.id.convert)
        val outputText:TextView = findViewById(R.id.output)
        val inputText:EditText = findViewById(R.id.input)
        val fromValue:Spinner = findViewById(R.id.from_value)
        val toValue:Spinner = findViewById(R.id.to_value)

        val options:ArrayAdapter<*> = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,
            arrayOf("Kilo-meter","Meter","Deci-meter","Centi-meter","Millimeter")
        )
        fromValue.adapter = options
        toValue.adapter = options
        options.setDropDownViewResource(R.layout.spinner_style)

        convertButton.setOnClickListener {
            if (inputText.text.isEmpty() or (inputText.text.toString() == "."))
                outputText.text = "Please enter some value"
            else{
            when(fromValue.selectedItemPosition){
                // From Kilometer
                0 ->{
                    when(toValue.selectedItemPosition){
                        // To Kilometer
                        0 -> outputText.text = "${ inputText.text.toString().toFloat()} Kilometers"
                        // To Meter
                        1 -> outputText.text = "${ inputText.text.toString().toFloat() * 1000 } Meters"
                        // To Decimeter
                        2 -> outputText.text = "${ inputText.text.toString().toFloat() * 1000 * 10} Decimeters"
                        // To Centimeter
                        3 -> outputText.text = "${ inputText.text.toString().toFloat() * 1000 * 100}"+" Centimeters"
                        // To Centimeter
                        4 -> outputText.text = "${ inputText.text.toString().toFloat() * 1000 * 100 * 10}"+" Millimeters"
                    }
                }
                // From Meter
                1 ->{
                    when(toValue.selectedItemPosition){
                        // To Kilometer
                        0 -> outputText.text = "${ inputText.text.toString().toFloat() / 1000} Kilometers"
                        // To Meter
                        1 -> outputText.text = "${ inputText.text.toString().toFloat()} Meters"
                        // To Decimeter
                        2 -> outputText.text = "${ inputText.text.toString().toFloat()* 10} Decimeters"
                        // To Centimeter
                        3 -> outputText.text = "${ inputText.text.toString().toFloat() * 100}"+" Centimeters"
                        // To Centimeter
                        4 -> outputText.text = "${ inputText.text.toString().toFloat() * 100 * 10}"+" Millimeters"
                    }
                }
                // From Decimeter
                2 ->
                    when(toValue.selectedItemPosition){
                        // To Kilometer
                        0 -> outputText.text = "${ inputText.text.toString().toFloat() /1000/10} Kilometers"
                        // To Meter
                        1 -> outputText.text = "${ inputText.text.toString().toFloat() / 10} Meters"
                        // To Decimeter
                        2 -> outputText.text = "${ inputText.text.toString().toFloat()} Decimeters"
                        // To Centimeter
                        3 -> outputText.text = "${ inputText.text.toString().toFloat() * 10}"+" Centimeters"
                        // To Centimeter
                        4 -> outputText.text = "${ inputText.text.toString().toFloat() * 10 * 10}"+" Millimeters"
                    }
                // From Centimeter
                3 ->
                    when(toValue.selectedItemPosition){
                        // To Kilometer
                        0 -> outputText.text = "${ inputText.text.toString().toFloat() /1000/100} Kilometers"
                        // To Meter
                        1 -> outputText.text = "${ inputText.text.toString().toFloat() / 100} Meters"
                        // To Decimeter
                        2 -> outputText.text = "${ inputText.text.toString().toFloat() / 10} Decimeters"
                        // To Centimeter
                        3 -> outputText.text = "${ inputText.text.toString().toFloat()} Centimeters"
                        // To Centimeter
                        4 -> outputText.text = "${ inputText.text.toString().toFloat() * 10}"+" Millimeters"
                    }
                // From Millimeter
                4 ->
                    when(toValue.selectedItemPosition){
                        // To Kilometer
                        0 -> outputText.text = "${ inputText.text.toString().toFloat()/1000/100/10} Kilometers"
                        // To Meter
                        1 -> outputText.text = "${ inputText.text.toString().toFloat() /100/10} Meters"
                        // To Decimeter
                        2 -> outputText.text = "${ inputText.text.toString().toFloat() /10/10} Decimeters"
                        // To Centimeter
                        3 -> outputText.text = "${ inputText.text.toString().toFloat() /10} Centimeters"
                        // To Centimeter
                        4 -> outputText.text = "${ inputText.text.toString().toFloat()} Millimeters"
                    }
            }
        }
            outputText.visibility = View.VISIBLE
        }
    }
}