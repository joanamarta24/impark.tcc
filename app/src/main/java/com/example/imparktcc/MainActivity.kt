package com.example.imparktcc

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imparktcc.ui.CadastroCarroScreen
import com.example.imparktcc.ui.theme.ImparktccTheme

class CadastroUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImparktccTheme {
                AppNavigation()
            }
        }
    }
}
@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "usuario"){
        composable("usuario"){}
        CadastroUsuarioScreen(navController){
            composable("carro")
            CadastroCarroScreen()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun
