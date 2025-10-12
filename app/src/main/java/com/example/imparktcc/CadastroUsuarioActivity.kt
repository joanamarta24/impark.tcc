package com.example.imparktcc

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.imparktcc.ui.navigation.cadastroGraph
import com.example.imparktcc.ui.theme.ImparktccTheme

class CadastroUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImparktccTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "usuario"
                ) {
                    cadastroGraph(navController)
                }
            }
        }
    }
}