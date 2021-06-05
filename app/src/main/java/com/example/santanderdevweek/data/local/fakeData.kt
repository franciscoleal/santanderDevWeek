package com.example.santanderdevweek.data.local

import com.example.santanderdevweek.data.Cartao
import com.example.santanderdevweek.data.Cliente
import com.example.santanderdevweek.data.Conta

class FakeData {
    fun getLocalData() : Conta {
        return Conta(
            "4455655-4",
            "6552-4",
            "2.450,89",
            "4.120,00",
            cliente = Cliente("Francisco Leal"),
            cartao = Cartao("7689"),
        )
    }
}