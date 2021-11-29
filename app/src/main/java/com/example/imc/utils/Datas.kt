package com.example.imc.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun convertStringToLocalDate(brazilDate: String) : LocalDate {

    val dateFormatterFromBrazil = DateTimeFormatter
        .ofPattern("dd/MM/yyyy")

    val localDateFormat = LocalDate
        .parse(brazilDate, dateFormatterFromBrazil)

    return localDateFormat
}

fun calcularIdade(dataNascimento: String) : Int {

    // obter a data de hj
    val hoje = LocalDate.now()

    // converter a data de nascimento em um local date

    val nascimentoArray = dataNascimento.split("-"). toTypedArray()

    val nascimento = LocalDate.of(
        nascimentoArray[0].toInt(),
        nascimentoArray[1].toInt(),
        nascimentoArray[2].toInt()
    )

    val idade = Period.between(nascimento, hoje).years
    return idade

}

fun getDataAtualBrasil(): String {

    val hoje = LocalDate.now()

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    val dataBrasil = hoje.format(formatter)

//    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
//
//    val dt1 = LocalDate.parse("15/03/1990", formatter)

    return dataBrasil
}

fun converterLocalDateEmDataBrasil() {

}