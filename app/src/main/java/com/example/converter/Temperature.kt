package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Temperature : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
        supportActionBar?.title = "Temperature"
        val convertButton: Button = findViewById(R.id.convert)
        val outputText: TextView = findViewById(R.id.output)
        val inputText: EditText = findViewById(R.id.input)
        val fromValue: Spinner = findViewById(R.id.from_value)
        val toValue: Spinner = findViewById(R.id.to_value)

        val options: ArrayAdapter<*> = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,
            arrayOf("°C","°F","°K")
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
                        //From C
                        when(toValue.selectedItemPosition){
                            //To C
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()} °C"
                            //To F
                            1 -> outputText.text = "${ (inputText.text.toString().toFloat()*9/5)+32} °F"
                            //To K
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()+273.15} °K"
                        }
                    }
                    1 ->{
                        //From F
                        when(toValue.selectedItemPosition){
                            //To C
                            0 -> outputText.text = "${ (inputText.text.toString().toFloat()-32)*5/9} °C"
                            //To F
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()} °F"
                            //To K
                            2 -> outputText.text = "${ (inputText.text.toString().toFloat()-32)*5/9 + 273.15} °K"
                        }
                    }
                    2 ->
                        //From K
                        when(toValue.selectedItemPosition){
                            //To C
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()-273.15} °C"
                            //To F
                            1 -> outputText.text = "${ ((inputText.text.toString().toFloat()-273.15)*9/5)+32} °F"
                            //To K
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()} °K"
                        }
                }
            }
            outputText.visibility = View.VISIBLE
        }
    }
}