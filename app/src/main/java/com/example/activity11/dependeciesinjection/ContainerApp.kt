package com.example.activity11.dependeciesinjection

import android.content.Context
import com.example.activity11.data.database.KrsDatabase
import com.example.activity11.repository.LocalRepositoryMhs
import com.example.activity11.repository.RepositoryMhs

interface InterfaceContainerApp {
    val repositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp{
    override val repositoryMhs : RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}