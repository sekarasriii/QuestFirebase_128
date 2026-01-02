package com.example.meet14_firebase.view.route

import com.example.meet14_firebase.R

object DestinasiEdit:DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}
