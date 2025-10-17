package com.example.imparktcc.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.imparktcc.repository.CadastroRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CadastroViewModel @Inject constructor(
    private val repository: CadastroRepository
): ViewModel (){
    private val _uiState : StateFlow<Cadas>
}