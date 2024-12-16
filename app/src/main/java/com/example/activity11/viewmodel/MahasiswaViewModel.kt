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

    fun updateState(mahasiswaEvent: MahasiswaEvent){
        uiState = uiState.copy(
            mahasiswaEvent = mahasiswaEvent,
        )

    }
    private  fun validateFields() : Boolean{
        val event = uiState.mahasiswaEvent
        val errorState = FormErrorState(
            nim = if (event.nim.isEmpty()) "NIM tidak boleh kosong" else null,
            nama = if (event.nama.isEmpty()) "Nama tidak boleh kosong" else null,
            jenisKelamin = if (event.jenisKelamin.isEmpty()) "Jenis Kelamin tidak boleh kosong" else null,
            alamat = if (event.alamat.isEmpty()) "Alamat tidak boleh kosong" else null,
            kelas = if (event.kelas.isEmpty()) "Kelas tidak boleh kosong" else null,
            angkatan = if (event.angkatan.isEmpty()) "Angkatan tidak boleh kosong" else null
        )
        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun saveData() {

        val currentEvent = uiState.mahasiswaEvent

        if (validateFields()) {
            viewModelScope.launch {
                try {
                    repositoryMhs.insertMhs(currentEvent.toMahasiswaEntity())
                    uiState = uiState.copy(
                        snackBarMessage = "Data berhasil disimpan",
                        mahasiswaEvent = MahasiswaEvent(),
                        isEntryValid = FormErrorState()
                    )
                } catch (e: Exception) {
                    uiState = uiState.copy(
                        snackBarMessage = "Data gagal disimpan"
                    )
                }
            }
        }else {
            uiState = uiState.copy(
                snackBarMessage = "Data tidak valid. Periksa kembali data Anda."
            )
        }
    }
    //reset pesan snackbar setelah ditampilkan
    fun resetSnackBarMessage() {
        uiState = uiState.copy(
            snackBarMessage = null
        )
    }
}
