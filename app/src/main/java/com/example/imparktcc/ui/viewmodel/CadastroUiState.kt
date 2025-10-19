package com.example.imparktcc.ui.viewmodel

import android.R
import android.provider.ContactsContract.DisplayNameSources.EMAIL


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
    val tempoProcessoCadastro: Long
        get() = if (timestampFimCadastro > timetampInicioCadastro){
            (timestampFimCadastro - timetampInicioCadastro) / 1000
        }else 0L
    val exibirAvisoTentativas: Boolean
        get() = tentativasCadastro >= 3 && !cadastroSucesso
    val progressoCadastro: Int
        get() = when{
            cadastroSucesso -> 100
            isLoading -> 50
            formularioValido -> 25
            else -> 0
        }
    fun copyComValidacao(
        nome: String = this.nome,
        email: String = this.email,
        senha: String = this.senha,
       confirmarSenha: String = this.confirmarSenha
    ): CadastroUiState {
        return this.copy(
            nome = nome,
            email = email,
            senha = senha,
            confirmarSenha = confirmarSenha,
            // Revalida todos os campos
            camposPreenchidos = nome.isNotBlank() && email.isNotBlank() &&
                    senha.isNotBlank() && confirmarSenha.isNotBlank(),
            emailValido = isValidEmail(email),
            senhaValida = isValidPassword(senha),
            senhasCoincidem = senha == confirmarSenha && senha.isNotBlank()
        )
    }
    fun copyComLoading(): CadastroUiState{
        return this.copy(
            isLoading = true,
            mensagemErro = "",
            timestampInicioCadastro = System.currentTimeMillis()
        )
    }
    fun copyComSucesso(): CadastroUiState{
        return this.copy(
            isLoading = false,
            cadastroSucesso = true,
            mensagemErro = "",
            timestampFimCadastro = System.currentTimeMillis()

        )
    }
    fun copyComFoco(campo: CampoFocado): CadastroUiState{
           return this.copy(campoComFoco = campo)
    }
    fun copyComEstadoConexao(conectado: Boolean): CadastroUiState{
        return this.copy(conexaoInternet = conectado)

    }
    fun getMensagemErro(campo: CampoFocado? = null):String?{
        return while (campo ?: campoComFoco){
            CampoFocado.NOME -> if(nome.isBlank()) "Nome é obrigatorio" else null
            CampoFocado>EMAIL -> if
        }
    }

}