@file:OptIn(InternalSerializationApi::class)

package com.example.meet14_firebase.viewmodel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import  kotlinx.serialization.InternalSerializationApi
import com.example.meet14_firebase.modeldata.Siswa
import com.example.meet14_firebase.repositori.RepositorySiswa
import com.example.meet14_firebase.view.route.DestinasiDetail
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.IOException
import androidx.compose.runtime.setValue

sealed interface StatusUIDetail {
    data class Success(val satusiswa: Siswa?) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}