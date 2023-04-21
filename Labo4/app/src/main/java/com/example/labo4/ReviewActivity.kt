package com.example.labo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ReviewActivity : AppCompatActivity() {
    private lateinit var nombreTextView:TextView
    private lateinit var correoTextView:TextView
    private lateinit var celularTextView:TextView
    private lateinit var shareButton: Button

    //data
    private var nombre = ""
    private var correo = ""
    private var telefono = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        bind()
        recieveInfo()
        addListeners()
    }

    private fun bind(){
        nombreTextView = findViewById(R.id.nombre_text_view)
        correoTextView = findViewById(R.id.correo_text_view)
        celularTextView = findViewById(R.id.numero_text_view)
        shareButton = findViewById(R.id.share_button)
    }

    private fun recieveInfo(){
        nombre= intent.getStringExtra(MainActivity.NOMBRE).toString()
        correo= intent.getStringExtra(MainActivity.CORREO).toString()
        telefono= intent.getStringExtra(MainActivity.TELEFONO).toString()

        nombreTextView.text = "Nombre: $nombre"
        correoTextView.text = "Correo electrónic: $correo"
        celularTextView.text = "Número de teléfono: $telefono"


    }

    private fun addListeners()
    {
        shareButton.setOnClickListener {
            val share = Intent(Intent.ACTION_SEND)
            share.setType("text/plain")
            share.putExtra(Intent.EXTRA_TEXT,"Información compartida: Nombre: $nombre, Correo: $correo, Telefono: $telefono")
            startActivity(Intent.createChooser(share,"Nombre: $nombre, Correo: $correo, Telefono: $telefono"))
        }
    }
}