package com.example.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R
import com.example.santanderdevweek.data.Conta
import java.lang.RuntimeException


class MainActivity : AppCompatActivity() {

    //com esse lateinit serão construidos no futuro de forma atrasada
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(2000)

        setTheme(R.style.Theme_SantanderDevWeek)

        setContentView(R.layout.activity_main)
        //minhaIdade()
        //getter e setter estão implementados de forma implicita
        //val medicamento = Medicamento("teste 1","2x ao dia")

        //quando nossa tela for criada, mostre nossa toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()


    }

    private fun buscarContaCliente(){
        mainViewModel.buscarContaCliente().observe(this, Observer {
            result -> bindOnView(result)
        })
    }

    private fun bindOnView(conta: Conta ){
        findViewById<TextView>(R.id.tv_agencia).text = conta.agencia;
        findViewById<TextView>(R.id.tv_conta_corrente).text = conta.conta;
        findViewById<TextView>(R.id.tv_saldo).text = conta.saldo
        findViewById<TextView>(R.id.tv_valor_saldo_limite).text = conta.limite
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome
        findViewById<TextView>(R.id.tv_cartao_final_valor).text = conta.cartao.numeroCartao
    }



    //metodo para chamar o menu na activity - assim é possível inflar o recurso do menu - carregá-lo como um objeto na atividade ou no fragmento
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflar - importar nosso menu - exibir o menu
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }
    // conseguimos com esse metodo gerenciar nossos cliques no menuItem
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_1 -> {
                Log.d("Click", "Click no item 1")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }




    /*//        declaração de variaveis
    //val - value / var
    //quando se usar val - esse valor não pode ser mudado
    //quando se usa var - esse valor pode ser modificado

    var contador : Int = 10
    contador = 11

    val contador2 : Int = 11
//        contador2 = 12

    //segurança nula -  com o ponto de
// interrogação pode tornar a variavel nula conscientemente
    val languageName : String? = null

    //        condicionais
    var idade = 20

    *//* if (idade > 18) {
         println("Você é maior de idade")
     } else {
         println("Você é menor de idade")
     }

     val minhaIdade : String = if (idade > 18) {
         "Você é maior de idade"
     } else {
         "Você é menor de idade"
     }*//*

    //when - quando
    val minhaIdade = when{
        idade > 18 -> "Você é maior de idade"
        else -> "Você é menor de idade"
    }

    //funções no kotlin
    fun minhaIdade() : String = "Minha idade é 18"

    */



}