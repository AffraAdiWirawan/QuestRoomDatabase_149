package com.example.activity11.viewmodel

import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.activity11.data.entity.Mahasiswa
import com.example.activity11.repository.RepositoryMhs
import kotlinx.coroutines.launch

class MahasiswaViewModel(
    private val repositoryMhs: RepositoryMhs
) :ViewModel(){

    var uiState by mutableStateOf(MhsUIState())

    
}
