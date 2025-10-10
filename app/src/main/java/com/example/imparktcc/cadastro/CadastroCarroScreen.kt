package com.example.imparktcc.ui

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CadastroCarroScreen(
    onCadastroConcluido: () -> Unit = {}
) {
    var modelo by remember { mutableStateOf(TextFieldValue("")) }
    var placa by remember { mutableStateOf(TextFieldValue("")) }
    var cor by remember { mutableStateOf(TextFieldValue("")) }
    var sucesso by remember { mutableStateOf(false) }
    var visible by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    Box(modifier = Modifier.fillMaxSize()) {
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
                    sucesso = true
                    visible = true
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Cadastrar")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Mensagem animada simples
            AnimatedVisibility(
                visible = sucesso,
                enter = slideInVertically {
                    with(density) { -40.dp.roundToPx() }
                } + expandVertically(expandFrom = Alignment.Top) + fadeIn(initialAlpha = 0.3f),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                Text(
                    text = " Carro cadastrado com sucesso!",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color(0xAA000000))
            ) {
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
                        text = " Carro cadastrado!",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
    LaunchedEffect(sucesso) {
        if (sucesso) {
            delay(3000)
            sucesso = false
            visible = false
            onCadastroConcluido()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCadastroCarro() {
    ImparktccTheme {
        CadastroCarroScreen()
    }
}

@Composable
fun ImparktccTheme(content: @Composable () -> CadastroCarroScreen) {
    TODO("Not yet implemented")
}
