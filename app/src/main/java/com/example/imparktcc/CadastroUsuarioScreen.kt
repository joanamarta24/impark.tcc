package com.example.imparktcc

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroUsuarioScreen(navController: NavController, function: @Composable () -> Unit){}
var nome by remember { mutableStateOf("") }
var email by remember { mutableStateOf("") }
var senha by remember { mutableStateOf("") }
var confirmarSenha by remember { mutableStateOf("") }
        //Estados para Validação
var emailValido by remember { mutableStateOf(true) }
var senhaValida by remember { mutableStateOf(true) }
var senhasCoincidem by remember { mutableStateOf(true) }
var camposPreenchidos by remember { mutableStateOf(true) }
    //Estados para feedback visual
var cadastroSucesso by remember { mutableStateOf(false) }
