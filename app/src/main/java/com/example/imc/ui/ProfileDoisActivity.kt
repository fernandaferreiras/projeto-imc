package com.example.imc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.imc.R

class ProfileDoisActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvImc: TextView
    lateinit var tvNcd: TextView
    lateinit var tvPeso: TextView
    lateinit var tvIdade: TextView
    lateinit var tvAltura: TextView
//    lateinit var tvPerfil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_dois)

        tvNome = findViewById(R.id.profile_nome)
        tvProfissao = findViewById(R.id.profile_profissao)
        tvImc = findViewById(R.id.profile_imc)
        tvNcd = findViewById(R.id.profile_ncd)
        tvPeso = findViewById(R.id.profile_peso)
        tvIdade = findViewById(R.id.profile_idade)
        tvAltura = findViewById(R.id. profile_altura)


        carregarDashBoard()
    }

    private fun carregarDashBoard() {

        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()

    }


}