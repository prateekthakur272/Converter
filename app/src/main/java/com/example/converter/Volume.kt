package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Volume : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)
        supportActionBar?.title = "Volume"
        val convertButton: Button = findViewById(R.id.convert)
        val outputText: TextView = findViewById(R.id.output)
        val inputText: EditText = findViewById(R.id.input)
        val fromValue: Spinner = findViewById(R.id.from_value)
        val toValue: Spinner = findViewById(R.id.to_value)

        val options: ArrayAdapter<*> = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,
            arrayOf("Liter","Milliliter","Gallon")
        )
        fromValue.adapter = options
        toValue.adapter = options
        options.setDropDownViewResource(R.layout.spinner_style)
        convertButton.setOnClickListener {
            if (inputText.text.isEmpty() or (inputText.text.toString() == "."))
                outputText.text = "Please enter some value"
            else{
                when(fromValue.selectedItemPosition){
                    0 ->{
                        //From Liter
                        when(toValue.selectedItemPosition){
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()} Liters"
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()*1000} Milliliters"
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()/4.54609} Gallon"
                        }
                    }
                    //From Milliliter
                    1 ->{
                        when(toValue.selectedItemPosition){
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()/1000} Liters"
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()} Milliliters"
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()/1000/4.54609} Gallon"
                        }
                    }
                    //From Gallon
                    2 ->
                        when(toValue.selectedItemPosition){
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()*4.54609} Liters"
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()*4.54609*1000} Milliliters"
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()} Gallon"
                        }
                }
            }
            outputText.visibility = View.VISIBLE
        }
    }
}