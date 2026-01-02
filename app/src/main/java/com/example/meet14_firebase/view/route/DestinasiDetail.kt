package com.example.meet14_firebase.view.route

import com.example.meet14_firebase.R

object DestinasiDetail: DestinasiNavigasi {
    override val route = "item_detail"
    override val titleRes = R.string.detail_siswa
    const val siswaIdArg = "siswaId"
    val routeWithArgs = "$route/{$siswaIdArg}"
}
