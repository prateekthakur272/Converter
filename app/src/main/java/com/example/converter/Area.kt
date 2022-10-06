package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Area : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area)
        supportActionBar?.title = "Area"
        val convertButton: Button = findViewById(R.id.convert)
        val outputText: TextView = findViewById(R.id.output)
        val inputText: EditText = findViewById(R.id.input)
        val fromValue: Spinner = findViewById(R.id.from_value)
        val toValue: Spinner = findViewById(R.id.to_value)

        val options: ArrayAdapter<*> = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,
            arrayOf("Meter sqr","Centimeter sqr","Foot sqr","Hectare","Acres","Inch sqr")
        )
        fromValue.adapter = options
        toValue.adapter = options
        options.setDropDownViewResource(R.layout.spinner_style)
        convertButton.setOnClickListener {
            if (inputText.text.isEmpty() or (inputText.text.toString() == "."))
                outputText.text = "Please enter some value"
            else{
                when(fromValue.selectedItemPosition){
                    // From Meter Square
                    0 ->{
                        when(toValue.selectedItemPosition){
                            // To Meter Square
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()} Meter sqr"
                            // To Centimeter Square
                            1 -> outputText.text = "${ inputText.text.toString().toFloat() * 100 *100} Centimeter sqr"
                            // To Square Feet
                            2 -> outputText.text = "${ inputText.text.toString().toFloat() * 10.764} Sqr feet"
                            // To Hectare
                            3 -> outputText.text = "${ inputText.text.toString().toFloat() / 10000}"+" Hectare"
                            // To Acres
                            4 -> outputText.text = "${ inputText.text.toString().toFloat() / 4047}"+" Acres"
                            // To Inch Square
                            5 -> outputText.text = "${ inputText.text.toString().toFloat() * 1550}"+" Inch sqr"
                        }
                    }
                    // From Centimeter Square
                    1 ->{
                        when(toValue.selectedItemPosition){
                            // To Meter Square
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()/10000} Meter sqr"
                            // To Centimeter Square
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()} Centimeter sqr"
                            // To Square feet
                            2 -> outputText.text = "${ inputText.text.toString().toFloat() /10000 * 10.764} Sqr feet"
                            // To Hectare
                            3 -> outputText.text = "${ inputText.text.toString().toFloat() / 10000/10000}"+" Hectare"
                            // To Acres
                            4 -> outputText.text = "${ inputText.text.toString().toFloat() /10000/ 4047}"+" Acres"
                            // To Inch Square
                            5 -> outputText.text = "${ inputText.text.toString().toFloat() /10000* 1550}"+" Inch sqr"
                        }
                    }
                    2 ->
                        //From Square Feet
                        when(toValue.selectedItemPosition){
                            //To Meter Square
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()/10.764} Meter sqr"
                            //To Centimeter Square
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()/10.764 * 10000} Centimeter sqr"
                            //To Square Feet
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()} Sqr feet"
                            //To Hectare
                            3 -> outputText.text = "${ inputText.text.toString().toFloat()/10.764/10000}"+" Hectare"
                            //To Acres
                            4 -> outputText.text = "${ inputText.text.toString().toFloat() /10.764/4047}"+" Acres"
                            //To Inch square
                            5 -> outputText.text = "${ inputText.text.toString().toFloat() /10.764 * 1550}"+" Inch sqr"
                        }
                    3 ->
                        // From Hactare
                        when(toValue.selectedItemPosition){
                            // To Meter Square
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()*10000} Meter sqr"
                            // To Centimeter Square
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()*10000*10000} Centimeter sqr"
                            //To Square feet
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()*10000*10.764} Sqr feet"
                            //To Hectare
                            3 -> outputText.text = "${ inputText.text.toString().toFloat()}"+" Hectare"
                            //To Acres
                            4 -> outputText.text = "${ inputText.text.toString().toFloat() *10000/4047}"+" Acres"
                            //To Inch Square
                            5 -> outputText.text = "${ inputText.text.toString().toFloat() *10000*1550}"+" Inch sqr"
                        }
                    4 ->
                        // From Acres
                        when(toValue.selectedItemPosition){
                            // To Meters
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()*4047} Meter sqr"
                            //To Centimeters
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()*4047*10000} Centimeter sqr"
                            //To Square Feet
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()*4047*10.764} Sqr feet"
                            //To Hectare
                            3 -> outputText.text = "${ inputText.text.toString().toFloat() *4047/10000}"+" Hectare"
                            //To Acres
                            4 -> outputText.text = "${ inputText.text.toString().toFloat()}"+" Acres"
                            //To Inch Square
                            5 -> outputText.text = "${ inputText.text.toString().toFloat() *4047*1550}"+" Inch sqr"
                        }
                    5 ->
                        //From Inch Square
                        when(toValue.selectedItemPosition){
                            //To Meters Square
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()/1550} Meter sqr"
                            //To Centimeter Square
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()/1550*10000} Centimeter sqr"
                            //To Square Feet
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()/1550*10.764} Sqr feet"
                            //To Hectare
                            3 -> outputText.text = "${ inputText.text.toString().toFloat()/1550/10000}"+" Hectare"
                            //To Acres
                            4 -> outputText.text = "${ inputText.text.toString().toFloat()/1550/4047}"+" Acres"
                            //To Inch Square
                            5 -> outputText.text = "${ inputText.text.toString().toFloat()}"+" Inch sqr"
                    }
                }
            }
            outputText.visibility = View.VISIBLE
        }
    }
}