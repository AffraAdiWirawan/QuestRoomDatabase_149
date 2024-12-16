package com.example.activity11

import android.app.Application
import com.example.activity11.dependeciesinjection.ContainerApp

class KrsApp : Application() {
    //Fungsinya Menyimpan
    lateinit var containerApp : ContainerApp

    override fun onCreate() {
        super.onCreate()
        //Membbuat instance Object
        containerApp = ContainerApp(this)
    }
}