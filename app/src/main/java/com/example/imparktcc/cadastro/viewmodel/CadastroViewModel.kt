package com.example.imparktcc.cadastro.viewmodel

import androidx.lifecycle.ViewModel
import com.example.imparktcc.repository.CadastroRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CadastroViewModel : ViewModel (){

    private val repository = CadastroRepository()

    // Estados do usuário
    private val _uiState = MutableStateFlow(CadastroUiState())
    val uiState : StateFlow<CadastroUiState> = _uiState.asStateFlow()

    fun updateNome(nome: String){
        uiState.value = _uiState.value.copy(
            nome = nome,
            camposPreenchidos = true
        )
    }
    fun updateEmail(email:String){
        _uiState.value = _uiState.value.copy(
            email = email,
            camposPreenchidos = true
        )
    }
    fun updateSenha(senha: String) {
        _uiState.value = _uiState.value.copy(
            senha = senha,
            senhaValida = true,
            senhasCoincidem = true
        )
    }
    fun updateConfirmarSenha(confirmarSenha: String) {
        _uiState.value = _uiState.value.copy(
            confirmarSenha = confirmarSenha,
            senhasCoincidem = true
        )
    }
    fun cadastrarUsuario(onSuccess: () -> Unit){
        if(validarCampos()){
            _uiState
        }
    }
}