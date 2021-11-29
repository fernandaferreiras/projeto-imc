package com.example.imc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.imc.R
import java.time.LocalDate

class PesarActivity : AppCompatActivity() {

    lateinit var tvDataPesagem: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesar)

        tvDataPesagem = findViewById(R.id.tv_datapesagem)

        tvDataPesagem.text = LocalDate.now().toString()
    }
}