package com.example.imparktcc

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
@Preview
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "usuario") {
        composable("usuario") {
            CadastroUsuarioScreen(navController)
        }
        composable("carro") {
            CadastroCarroScreen(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroUsuarioScreen(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Cadastro de Usuário") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )

            Button(
                onClick = { /* Salvar usuário no banco */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cadastrar")
            }

            Button(
                onClick = { navController.navigate("carro") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ir para Cadastro de Carro")
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CadastroCarroScreen(rememberNavController: NavHostController) {
    var modelo by remember { mutableStateOf(TextFieldValue("")) }
    var placa by remember { mutableStateOf(TextFieldValue("")) }
    var cor by remember { mutableStateOf(TextFieldValue("")) }
    var sucesso by remember { mutableStateOf(false) }
    var visible by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    Box(modifier = Modifier.fillMaxSize()) {
        // Conteúdo principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Cadastro de Carro",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = modelo,
                onValueChange = { modelo = it },
                label = { Text("Modelo") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = placa,
                onValueChange = { placa = it },
                label = { Text("Placa") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = cor,
                onValueChange = { cor = it },
                label = { Text("Cor") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    sucesso = !sucesso
                    visible = sucesso
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Cadastrar")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Mensagem animada dentro da tela (texto simples)
            AnimatedVisibility(
                visible = sucesso,
                enter = slideInVertically {
                    with(density) { -40.dp.roundToPx() }
                } + expandVertically(expandFrom = Alignment.Top) + fadeIn(initialAlpha = 0.3f),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                Text(
                    text = "✅ Carro cadastrado com sucesso!",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // Camada de fundo com efeito fade + notificação central
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            // Fundo escurecido
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color(0xAA000000))
            ) {
                // Notificação central vermelha
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .animateEnterExit(
                            enter = slideInVertically(),
                            exit = slideOutVertically()
                        )
                        .sizeIn(minWidth = 256.dp, minHeight = 64.dp)
                        .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Carro cadastrado!",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimatedGreeting(){
    var visible by remember { mutableStateOf(false) }
    val density = LocalDensity.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Button(onClick = {visible = !visible}) {
            Text(if (visible) "Ocultar" else "Mostrar")

        }
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically {
                // Slide in from 40 dp from the top.
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                // Expand from the top.
                expandFrom = Alignment.Top
            ) + fadeIn(
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {
            Text(
                text = "Hello",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImparktccTheme {
        AnimatedGreeting()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCadastroUsuario() {
    ImparktccTheme {
        CadastroUsuarioScreen(rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCadastroCarro() {
    ImparktccTheme {
        CadastroCarroScreen(rememberNavController())
    }
}