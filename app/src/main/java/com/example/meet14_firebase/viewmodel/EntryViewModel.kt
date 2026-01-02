package com.example.meet14_firebase.viewmodel

import com.example.meet14_firebase.repositori.RepositorySiswa
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import com.example.meet14_firebase.modeldata.UIStateSiswa
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.meet14_firebase.modeldata.DetailSiswa
import com.example.meet14_firebase.modeldata.toDataSiswa

class EntryViewModel(
    private val repositorySiswa: RepositorySiswa
) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(
        uiState: DetailSiswa = uiStateSiswa.detailSiswa
    ): Boolean {
        return with(uiState) {
            nama.isNotBlank() &&
                    alamat.isNotBlank() &&
                    telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(
                detailSiswa = detailSiswa,
                isEntryValid = validasiInput(detailSiswa)
            )
    }

    /* Fungsi untuk menyimpan data yang di-entry */
    suspend fun addSiswa() {
        if (validasiInput()) {
            repositorySiswa.postDataSiswa(
                uiStateSiswa.detailSiswa.toDataSiswa()
            )
        }
    }
}
