package com.example.imc.ui

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imc.R
import com.example.imc.model.Usuario
import com.example.imc.utils.convertStringToLocalDate
import java.time.LocalDate
import java.util.*

class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editNome: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editDataNascimento: EditText
    lateinit var radioF: RadioButton
    lateinit var radioM: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        editEmail = findViewById(R.id.edit_email)
        editSenha = findViewById(R.id.edit_senha)
        editNome = findViewById(R.id.edit_nome)
        editProfissao = findViewById(R.id.edit_profissao)
        editAltura = findViewById(R.id.edit_altura)
        editDataNascimento = findViewById(R.id.edit_data_nascimento)
        radioF = findViewById(R.id.radioF)
        radioM = findViewById(R.id.radioM)

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

            val nascimento = convertStringToLocalDate(editDataNascimento.text.toString())

            // criando objeto usuario
            val  usuario = Usuario(
                1,
                editNome.text.toString(),
                editEmail.text.toString(),
                editSenha.text.toString(),
                0,
                editAltura.text.toString().toDouble(),
                LocalDate.of(
                    nascimento.year,
                    nascimento.monthValue,
                    nascimento.dayOfMonth,
                ),
                editProfissao.toString(),
                if (radioF.isChecked){
                    'F'
                } else {
                    'M'
                }

            )

            // salvar registro em um SharedPrefenrences

            //criando um SharedPrefenrences se nao existir, se existir ele sera aberto para edicao
            val dados = getSharedPreferences("usuario", Context.MODE_PRIVATE)

            // criando um objeto que permitira a edicao dos dados do arquivo SharedPrefenrences

            val editor = dados.edit()
            editor.putInt("id", usuario.id)
            editor.putString("nome", usuario.nome)
            editor.putString("email", usuario.email)
            editor.putString("senha", usuario.senha)
            editor.putInt("peso", usuario.peso)
            editor.putFloat("altura", usuario.altura.toFloat())
            editor.putString("dataNascimento", usuario.dataNascimento.toString())
            editor.putString("profissao", usuario.profissao)
            editor.putString("sexo", usuario.sexo.toString())
            editor.apply()
        }

        Toast.makeText(this, "Usuario cadastrado", Toast.LENGTH_SHORT).show()

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