package com.example.labo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var fiveCentView:ImageView
    private lateinit var tenCentView:ImageView
    private lateinit var quarterView:ImageView
    private lateinit var dollarView:ImageView
    private lateinit var actualMoney:TextView
    var currentMoney:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListeners()
    }

    private fun addListeners(){
        fiveCentView.setOnClickListener{
            currentMoney += 0.05
            actualMoney.text = "%.2f".format(currentMoney)

        }
        tenCentView.setOnClickListener {
            currentMoney += 0.1
            actualMoney.text = "%.2f".format(currentMoney)

        }
        quarterView.setOnClickListener {
            currentMoney += 0.25
            actualMoney.text = "%.2f".format(currentMoney)

        }
        dollarView.setOnClickListener{
            currentMoney += 1
            actualMoney.text = "%.2f".format(currentMoney)

        }
    }

    private fun bind(){
        fiveCentView = findViewById(R.id.five_cent_img_view)
        tenCentView = findViewById(R.id.ten_cent_img_view)
        quarterView = findViewById(R.id.quarter_image_view)
        dollarView = findViewById(R.id.dollar_image_view)
        actualMoney = findViewById(R.id.cuenta_text_view)
    }
}