package com.example.meet14_firebase.view

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.meet14_firebase.viewmodel.DetailViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meet14_firebase.viewmodel.PenyediaViewModel
import androidx.compose.material3.Scaffold
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.FloatingActionButton
import com.example.meet14_firebase.view.route.DestinasiDetail
import com.example.meet14_firebase.viewmodel.StatusUIDetail
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.dimensionResource
import com.example.meet14_firebase.R
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import com.example.meet14_firebase.modeldata.Siswa
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AlertDialog
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.TextButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailSiswaScreen(
    navigateToEditItem: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    Scaffold(
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiDetail.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        },
}