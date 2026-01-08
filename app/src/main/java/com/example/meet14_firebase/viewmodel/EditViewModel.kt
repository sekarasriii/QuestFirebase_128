package com.example.meet14_firebase.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.meet14_firebase.modeldata.UIStateSiswa
import com.example.meet14_firebase.repositori.RepositorySiswa
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import com.example.meet14_firebase.view.route.DestinasiDetail
import  androidx.lifecycle.viewModelScope
import com.example.meet14_firebase.modeldata.toDataSiswa
import kotlinx.coroutines.launch
import com.example.meet14_firebase.modeldata.DetailSiswa
import androidx.compose.runtime.setValue
import com.example.meet14_firebase.modeldata.toUiStateSiswa

class EditViewModel (savedStateHandle: SavedStateHandle, private val repositorySiswa:
RepositorySiswa): ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private val idSiswa: Long =
        savedStateHandle.get<String>(DestinasiDetail.itemIdArg)?.toLong()
            ?: error("idSiswa tidak ditemukan di SavedStateHandle")

    init {
        viewModelScope.launch {
            uiStateSiswa = repositorySiswa.getSatuSiswa(idSiswa)!!
                .toUiStateSiswa(true)
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    suspend fun editSatuSiswa() {
        if (validasiInput(uiStateSiswa.detailSiswa)) {
            try {
                repositorySiswa.editSatuSiswa(idSiswa, uiStateSiswa.detailSiswa.toDataSiswa())
                println("Update Sukses: $idSiswa")
            } catch (e: Exception) {
                println("Update Error: ${e.message}")
            }
        }
    }
}