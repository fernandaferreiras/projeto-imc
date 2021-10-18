package com.example.imc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import java.util.*

class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editNome: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editDataNascimento: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        editEmail = findViewById(R.id.edit_email)
        editSenha = findViewById(R.id.edit_senha)
        editNome = findViewById(R.id.edit_nome)
        editProfissao = findViewById(R.id.edit_profissao)
        editAltura = findViewById(R.id.edit_altura)
        editDataNascimento = findViewById(R.id.edit_data_nascimento)

        supportActionBar!!.title = "Novo Usuario"

        val calendario = Calendar.getInstance()

        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        val etDataNacimento = findViewById<EditText>(R.id.edit_data_nascimento)

        etDataNacimento.setOnClickListener {
            val dp = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->
                    etDataNacimento.setText(
                        "$_dia/${_mes + 1}/$_ano"
                    )
                },
                ano,
                mes,
                dia
            )
            dp.show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_perfil, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (validarCampos()) {
        }

        return true
    }

    fun validarCampos(): Boolean {
        var valido = true
        if (editEmail.text.isEmpty()) {
            editEmail.error = "O e-mail é obrigatório"
            valido = false
        }
        if (editSenha.text.isEmpty()) {
            editSenha.error = "A senha é obrigatória"
            valido = false
        }
        if (editNome.text.isEmpty()) {
            editNome.error = "O nome é obrigatório"
            valido = false
        }
        if (editProfissao.text.isEmpty()) {
            editProfissao.error = "A profissão é obrigatória"
            valido = false
        }
        if (editAltura.text.isEmpty()) {
            editAltura.error = "A altura é obrigatória"
            valido = false
        }
        if (editDataNascimento.text.isEmpty()) {
            editDataNascimento.error = "A data de nascimento é obrigatória"
            valido = false
        }

        return valido

    }


}