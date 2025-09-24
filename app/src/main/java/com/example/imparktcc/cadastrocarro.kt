package com.example.imparktcc

import android.os.Binder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CadastroCarroActivity : AppCompatActivity(){
    private lateinit var binding:ActivityCadastroCarroBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding= CadastroCarroActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }
    private fun setupListeners(){
        binding.btnCadastrarCarro.setOnClickListener{
            cadastrarCarro()
        }
    }
    private fun cadastrarCarro(){
        val marca = binding.etMarcaCarro.text.toString().trim()
        val modelo = binding.etModeloCarro.text.toString().trim()
        val ano = binding.etAnoCarro.text.toString().trim()
        val placa = binding.etPlacaCarro.text.toString.trim()
        val cor = binding.etCorCarro.text.toString.trim()

        //Limpa mensagens de erro anteriores
        binding.tilMarcaCarro.erro = null
        binding.tiModeloCarro.erro = null
        binding.tiAnoCarro.erro = null
        binding.tiPlacaCarro.erro = null
        binding.tiCorCarro.errp = null

        var is Valid = true

        if (marca.isEmpty()){
            binding.tilMarcaCarro.errorg
            b
        }

    }
}