package com.example.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.santanderdevweek.data.Conta
import com.example.santanderdevweek.data.local.FakeData

class MainViewModel: ViewModel() {
    //trafegar os dados pela <Conta> - responsavel por setar um valor observado no futuro
    // livedata - só repassa dados, mutableLiveData - consegue mudar valores
    private val mutableLivedata: MutableLiveData<Conta> = MutableLiveData()

    // trafega nossos dados para que eles possam ser observados futuramente
    fun buscarContaCliente() : LiveData<Conta> {
        mutableLivedata.value = FakeData().getLocalData()

        return mutableLivedata
    }
}