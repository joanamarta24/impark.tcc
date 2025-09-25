package com.example.imparktcc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.imparktcc.ui.theme.ImparktccTheme

class CadastroUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CadastroUsuarioScreen()
        }
    }
}
@Composable
fun AppNavigation(){
    val  navController: rememberNavController()
    NavHost(navController = navController, startDestination = "usuario"){
        composable("usuario"){ CadastroUsuarioScreen(navController) }
        composable("carro"){ CadastroUsuarioScreen(navController) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroUsuarioScreen(){
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Scaffold (
        topBar = {
            TopAppBar(title = {Text("Cadastro de Usuário")})
        }
    ){  padding ->
        Column (
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it},
                label = {Text("Nome")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))

            OutlinedTextField(
              value = email,
                onValueChange = {email = it},
                label = {Text("E-mail")},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))

            OutlinedTextField(
                value = senha,
                onValueChange = {senha = it},
                label = {Text("Senha")},
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
            Button(
                onClick = {/*Salvar usuário no bamco*/},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cadastrar")
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCadastroUsuario(){
    ImparktccTheme {
        CadastroUsuarioScreen()
    }
}
@Composable
fun CadastroCarroScreen(navController:NavHostController){
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var ano by remember { mutableStateOf("") }
    var placa by remember { mutableStateOf("") }
    Scaffold (
        topBar ={
        TopAppBar(title = { Text("Cadastro de Carro") })
        }
    ){  padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                 elevation =CardDefaults.cardElevation(6.dp)
            ) {
                Column (modifier = Modifier.padding(16.dp)){
                    OutlinedTextField(
                        value = marca,
                        onValueChange = {marca = it},
                        label = { Text("Marca") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(16.dp))
                    OutlinedTextField(
                        value = modelo,
                        onValueChange = {modelo = it},
                        label = { Text("Modelo") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(12.dp))
                    OutlinedTextField(
                        value = ano,
                        onValueChange = {ano = it},
                        label ={ Text("Ano") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(12.dp))


                }
            }

        }

    }
}