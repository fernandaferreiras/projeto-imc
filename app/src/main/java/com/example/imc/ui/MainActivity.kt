package com.example.imc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.imc.R
import com.example.imc.calcularImc

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.button_calcular)
        val etPeso = findViewById<EditText>(R.id.edit_text_peso)
        val etAltura = findViewById<EditText>(R.id.edit_text_altura)
        val textResultado = findViewById<EditText>(R.id.edit_text_peso)

        // → val é imutavel
        // → var é mutavel

        btnCalcular.setOnClickListener{
            val peso = etPeso.text.toString().toInt()
            val altura = etAltura.text.toString().toDouble()

            val imc = calcularImc (peso, altura)

            // textResultado.text = String().format("%.2f", imc)
                    // para formatar a casa decimal deve-se colocar o "f"
        }
    }
}