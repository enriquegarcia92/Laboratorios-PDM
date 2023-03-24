package com.example.labo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var bmiTextView:TextView
    private lateinit var healthTextView:TextView
    private lateinit var rangeTextView:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListeners()
    }

    private fun bind(){
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        calculateButton = findViewById(R.id.btn_calculate)
        bmiTextView = findViewById(R.id.bmi_text)
        healthTextView=findViewById(R.id.health_state_text)
        rangeTextView=findViewById(R.id.range_text)
    }

    private fun addListeners(){
        calculateButton.setOnClickListener {
            var height = heightEditText.text.toString()
            var weight = weightEditText.text.toString()
            if(validateIntput(weight,height)) {
                var BMIresult = calculateBMI(weight.toFloat(), height.toFloat())
                bmiTextView.text = BMIresult.toString()
                if (BMIresult < 18.5) {

                } else if (BMIresult <= 18.5) {
                    healthTextView.text = "Underweight"
                    rangeTextView.text = "Less than 18.5 "
                    healthTextView.setTextColor(getColor(R.color.under_weight))
                } else if (BMIresult > 18.5 && BMIresult < 24.99) {
                    healthTextView.text = "Healthy"
                    rangeTextView.text = "Between 18.5 - 24.99"
                    healthTextView.setTextColor(getColor(R.color.normal_weight))
                } else if (BMIresult > 25 && BMIresult < 29.99) {
                    healthTextView.text = "Overweight"
                    rangeTextView.text = "between 25 - 29.99"
                    healthTextView.setTextColor(getColor(R.color.over_weight))
                } else if (BMIresult > 30) {
                    healthTextView.text = "Obese"
                    rangeTextView.text = "Greater than 30 "
                    healthTextView.setTextColor(getColor(R.color.obese))
                }
            }
        }
    }

    private fun calculateBMI(weight:Float, height:Float):Float{
        return weight/((height/100)*(height/100))
    }

    private fun validateIntput(weight: String?, height:String?): Boolean{
        return when{
            weight.isNullOrEmpty()->{
                Toast.makeText(this,"Weight is empty",Toast.LENGTH_SHORT)
                return false
            }
            height.isNullOrEmpty()->{
                Toast.makeText(this,"Weight is empty",Toast.LENGTH_SHORT)
                return false
            }
            else -> true
        }
    }
}