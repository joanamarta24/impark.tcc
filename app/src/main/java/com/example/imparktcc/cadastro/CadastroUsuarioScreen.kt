package com.example.imparktcc.cadastro

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api ::class)
@Composable
fun CadastroUsuarioScreen(navController: NavController, function:@Composable () -> Unit){
    var nome by remember { mutableStateOf("") }
    var  email by remember { mutableStateOf("") }
    var  senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }

    var emailValido by remember { mutableStateOf(true) }
    var senhaValida by remember { mutableStateOf(true) }
    var senhasCoincidem by remember { mutableStateOf(true) }
    var camposPreenchidos by remember { mutableStateOf(true) }

    var cadastroSucesso by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    var mensagemErro by remember { mutableStateOf("") }

    val emailRegex = Regex ("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$")

    fun validarSenha(senha:String ):Boolean{
        return senha.length >= 6 && senha.any { it.isDigit() } && senha.any { it.isLetter() }

    }
    fun validarEmail(email:String): Boolean{
        return emailRegex.matches(email)
    }
    fun validarCampos():Boolean{
        val camposPreechidosValidos =
            nome.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty() && confirmarSenha.isNotEmpty()
        val emailValidoLocal = validarEmail(email)
        val senhaValidaLocal = validarSenha(senha)
        val senhasCoincidemLocal = senha == confirmarSenha

        camposPreechidosValidos = camposPreenchidosValidos
        emailValido = emailValidoLocal
        senhaValida = senhaValidaLocal
        senhasCoincidem = senhasCoincidemLocal

        return camposPreenchidosValidos && emailValidoLocal && senhaValidaLocal && senhasCoincidemLocal
    }
}
