package com.example.santanderdevweek.data

data class Conta(
    val conta: String,
    val agencia: String,
    val saldo: String,
    val limite: String,
    val cartao: Cartao,
    val cliente: Cliente

)