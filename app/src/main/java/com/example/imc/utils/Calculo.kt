package com.example.imc

fun calcularImc(peso: Int, altura: Double) : Double {
    return peso / (altura * altura)
}