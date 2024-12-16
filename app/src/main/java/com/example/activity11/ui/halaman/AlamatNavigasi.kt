package com.example.activity11.ui.halaman

interface AlamatNavigasi {
    val route: String

    object DestinasiHome : AlamatNavigasi {
        override val route = "home"
    }


}