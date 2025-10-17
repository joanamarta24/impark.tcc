package com.example.imparktcc.ui.viewmodel

import java.sql.Timestamp

data class CadastroUiState(
    // Campos do formulário
    val nome: String ="",
    val email: String ="",
    val senha: String ="",
    val confirmarSenha: String = "",
    // Estados de validação
    val emailValido: Boolean = true,
    val senhaValida: Boolean = true,
    val senhasCoincidem: Boolean = true,
    val camposPreenchidos : Boolean= true,

    //Estados de UI
    val cadastroSucesso: Boolean = false,
    val isLoading: Boolean = false,
    val mensagemErro: String ="",

    //Estados avançados
    val campoComFoco: CampoFocado? = null,
    val tentativasCadastro: Int = 0,
    val mostrarDicas : Boolean = false,
    val termosAceito:Boolean = false,
    val politicaPrivacidadeAceita: Boolean = false,

    // Timestamps para analytics
    val timetampInicioCadastro : Long = 0L,
    val timestampFimCadastro: Long = 0L,
    // Estados de rede
    val conexaoInternet: Boolean = true,
    val servidorOnLine: Boolean = true
){

    // Verifica se o formulário está completamente válido
    val formularioValido : Boolean
        get() = nome.isNotBlank() &&
                email.isNotBlank() &&
                senha.isNotBlank() &&
                confirmarSenha.isNotBlank() &&
                emailValido &&
                senhaValida &&
                senhasCoincidem &&
                termosAceito &&
                politicaPrivacidadeAceita
    //Verifica se pode habilitar o botão de cadastro
    val botaoCadastroHabilitado: Boolean
        get() = formularioValido && !isLoading && conexaoInternet

    //Calcula a forca da senha (0-4)
    val forcaSenha: Int
        get() = calculatePasswordStrength(senha)

}