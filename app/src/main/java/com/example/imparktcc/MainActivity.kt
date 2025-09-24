package com.example.imparktcc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.example.imparktcc.ui.theme.ImparktccTheme

class CadastroUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CadastroUsuarioScreen()
        }
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
            OutlinedTextField(
              value = email,
                onValueChange = {email = it},
                label = {Text("E-mail")},
                modifier = Modifier.fillMaxWidth()
            )
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