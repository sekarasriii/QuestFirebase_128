package com.example.meet14_firebase.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.meet14_firebase.viewmodel.EditViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meet14_firebase.viewmodel.PenyediaViewModel
import androidx.compose.material3.Scaffold
import androidx.compose.ui.res.stringResource
import com.example.meet14_firebase.view.route.DestinasiEdit
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.padding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditSiswaScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    Scaffold(
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiEdit.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    )