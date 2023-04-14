package com.example.labo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nombreEditText:EditText
    private lateinit var correoEditText: EditText
    private lateinit var celEditText:EditText
    private lateinit var saveButton: Button
    //datos
    private var nombre = ""
    private var correo = ""
    private var celular = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListeners()
    }

    private fun bind(){
        nombreEditText = findViewById(R.id.name_edit_text_content)
        correoEditText = findViewById(R.id.mail_edit_text_content)
        celEditText = findViewById(R.id.phone_edit_text_content)
        saveButton = findViewById(R.id.save_button)
    }
    private fun addListeners(){
        saveButton.setOnClickListener {
            nombre = nombreEditText.text.toString()
            correo = correoEditText.text.toString()
            celular = celEditText.text.toString()
            val intent = Intent(MainActivity@this,ReviewActivity::class.java)
            intent.putExtra(NOMBRE,nombre)
            intent.putExtra(CORREO,correo)
            intent.putExtra(TELEFONO,celular)

            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(NOMBRE,nombre)
        outState.putString(CORREO,correo)
        outState.putString(TELEFONO,celular)
    }

    companion object{
        const val TAG = ".MainActivity"
        const val NOMBRE ="NOMBRE"
        const val CORREO ="CORREO"
        const val TELEFONO ="TELEFONO"
    }

}