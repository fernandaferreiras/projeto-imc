package com.example.imc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.imc.R

class ActivityLogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        supportActionBar!!.hide()

        val criarConta = findViewById<TextView>(R.id.text_view_criar_conta)

        criarConta.setOnClickListener {
            val abrirNovoUsuario = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(abrirNovoUsuario)
        }
    }
}