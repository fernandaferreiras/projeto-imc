package com.example.imc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.imc.R
import com.example.imc.utils.autenticar

class ActivityLogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        supportActionBar!!.hide()

        val criarConta = findViewById<TextView>(R.id.text_view_criar_conta)
        val buttonEntrar = findViewById<Button>(R.id.button_entrar)

        val editEmail = findViewById<EditText>(R.id.edit_login_email)
        val editSenha = findViewById<EditText>(R.id.edit_login_senha)



        buttonEntrar.setOnClickListener {
            
            val autenticou = autenticar(
                editEmail.text.toString(),
                editSenha.text.toString(),
                this
            )
            
            if (autenticou) {
                val intent = Intent (
                    this, ProfileDoisActivity::class.java)
                startActivity(intent)
            } else  {
                Toast.makeText(this, "Usuario ou senha incorretos", Toast.LENGTH_SHORT).show()
//                Toast.makeText(this, "usuario ou senha incorretas")
            }
            
//            autenticar(editEmail.text.toString(), editSenha.text.toString(),this)
        }

        criarConta.setOnClickListener {
            val abrirNovoUsuario = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(abrirNovoUsuario)
        }

//        entrarNoPerdil.setOnClickListener {
//            val abrirPerfil = Intent(this, NovoUsuarioActivity::class.java)
//            startActivity(abrirPerfil)
//        }
    }
}