package com.example.imc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.imc.R
import com.example.imc.repository.PesagemRepository
import com.example.imc.utils.calcularIdade
import com.example.imc.utils.convertBase64ToBitmap


class ProfileDoisActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvImc: TextView
    lateinit var tvNcd: TextView
    lateinit var tvPeso: TextView
    lateinit var tvIdade: TextView
    lateinit var tvAltura: TextView
    lateinit var ivPerfil: ImageView
    lateinit var cardNovaPesagem: CardView
    lateinit var cardHistorico: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_dois)

        supportActionBar!!.hide()

        tvNome = findViewById(R.id.profile_nome)
        tvProfissao = findViewById(R.id.profile_profissao)
        tvImc = findViewById(R.id.profile_imc)
        tvNcd = findViewById(R.id.profile_ncd)
        tvPeso = findViewById(R.id.profile_peso)
        tvIdade = findViewById(R.id.profile_idade)
        tvAltura = findViewById(R.id. profile_altura)
        ivPerfil = findViewById(R.id.profile_foto)
        cardNovaPesagem = findViewById(R.id.card_view_pesar_agora)
        cardHistorico = findViewById(R.id.card_historico)

        cardNovaPesagem.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java)
            startActivity(intent)
        }

        cardHistorico.setOnClickListener {
            val pesagemRepository = PesagemRepository(this)
            val listaPesagem = pesagemRepository.getListaPesagem()

//            for (p in listaPesagem) {
//                Log.i("xpto", "${p.dataPesagem} - ${p.peso}")
//            }

        }


        carregarDashBoard()
    }

    private fun carregarDashBoard() {

        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()
        tvIdade.text = calcularIdade(arquivo.getString("dataNascimento", "")!!).toString()
        val bitmap = convertBase64ToBitmap(arquivo.getString("fotoPerfil", "")!!)
        ivPerfil.setImageBitmap(bitmap)


    }


}