package com.example.meet14_firebase.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.example.meet14_firebase.repositori.AplikasiDataSiswa
import androidx.lifecycle.viewmodel.CreationExtras
import  androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.viewmodel.initializer


fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa = (
        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as
                AplikasiDataSiswa
        )

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiDataSiswa().container.repositorySiswa) }
        initializer { EntryViewModel( aplikasiDataSiswa().container.repositorySiswa) }
    }
}
