package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Weight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)
        supportActionBar?.title = "Weight"
        val convertButton: Button = findViewById(R.id.convert)
        val outputText: TextView = findViewById(R.id.output)
        val inputText: EditText = findViewById(R.id.input)
        val fromValue: Spinner = findViewById(R.id.from_value)
        val toValue: Spinner = findViewById(R.id.to_value)

        val options: ArrayAdapter<*> = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,
            arrayOf("Kilogram","Gram","Pound","Milligram","Ounce","Tonn")
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
                        //From Kilogram
                        when(toValue.selectedItemPosition){
                            //To Kilogram
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()} Kilogram"
                            //To Gram
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()*1000} Gram"
                            //To Pound
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()*2.205} Pound"
                            //Milligram
                            3 -> outputText.text = "${ inputText.text.toString().toFloat()*1000*1000}"+" Milligram"
                            //Ounce
                            4 -> outputText.text = "${ inputText.text.toString().toFloat()*35.274}"+" Ounce"
                            //Tons
                            5 -> outputText.text = "${ inputText.text.toString().toFloat()/1000}"+" Tonn"
                        }
                    }
                    1 ->{
                        //From Gram
                        when(toValue.selectedItemPosition){
                            //To Kilogram
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()/1000} Kilogram"
                            //To Gram
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()} Gram"
                            //To Pound
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()/453.6} Pound"
                            //Milligram
                            3 -> outputText.text = "${ inputText.text.toString().toFloat()*1000}"+" Milligram"
                            //Ounce
                            4 -> outputText.text = "${ inputText.text.toString().toFloat()/28.35}"+" Ounce"
                            //Tons
                            5 -> outputText.text = "${ inputText.text.toString().toFloat()/1000/1000}"+" Tonn"
                        }
                    }
                    2 ->
                        //From Pound
                        when(toValue.selectedItemPosition){
                            //To Kilogram
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()/2.205} Kilogram"
                            //To Gram
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()*453.6} Gram"
                            //To Pound
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()} Pound"
                            //Milligram
                            3 -> outputText.text = "${ inputText.text.toString().toFloat()*453.6*1000}"+" Milligram"
                            //Ounce
                            4 -> outputText.text = "${ inputText.text.toString().toFloat()*16}"+" Ounce"
                            //Tons
                            5 -> outputText.text = "${ inputText.text.toString().toFloat()/2205}"+" Tonn"
                        }
                    3 ->
                        //From Milligram
                        when(toValue.selectedItemPosition){
                            //To Kilogram
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()/1000/1000} Kilogram"
                            //To Gram
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()/1000} Gram"
                            //To Pound
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()/453600} Pound"
                            //Milligram
                            3 -> outputText.text = "${ inputText.text.toString().toFloat()}"+" Milligram"
                            //Ounce
                            4 -> outputText.text = "${ inputText.text.toString().toFloat()/28350}"+" Ounce"
                            //Tons
                            5 -> outputText.text = "${ inputText.text.toString().toFloat()/1000000000}"+" Tonn"
                        }
                    4 ->
                        //From Ounce
                        when(toValue.selectedItemPosition){
                            //To Kilogram
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()/35.274} Kilogram"
                            //To Gram
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()*28.35} Gram"
                            //To Pound
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()/16} Pound"
                            //Milligram
                            3 -> outputText.text = "${ inputText.text.toString().toFloat()*28350}"+" Milligram"
                            //Ounce
                            4 -> outputText.text = "${ inputText.text.toString().toFloat()}"+" Ounce"
                            //Tons
                            5 -> outputText.text = "${ inputText.text.toString().toFloat()/35270}"+" Tonn"
                        }
                    5 ->
                        //From Tonn
                        when(toValue.selectedItemPosition){
                            //To Kilogram
                            0 -> outputText.text = "${ inputText.text.toString().toFloat()*1000} Kilogram"
                            //To Gram
                            1 -> outputText.text = "${ inputText.text.toString().toFloat()*1000*1000} Gram"
                            //To Pound
                            2 -> outputText.text = "${ inputText.text.toString().toFloat()*2205} Pound"
                            //Milligram
                            3 -> outputText.text = "${ inputText.text.toString().toFloat()*1000*1000*1000}"+" Milligram"
                            //Ounce
                            4 -> outputText.text = "${ inputText.text.toString().toFloat()*35270}"+" Ounce"
                            //Tons
                            5 -> outputText.text = "${ inputText.text.toString().toFloat()}"+" Tonn"
                        }
                }
            }
            outputText.visibility = View.VISIBLE
        }
    }
}