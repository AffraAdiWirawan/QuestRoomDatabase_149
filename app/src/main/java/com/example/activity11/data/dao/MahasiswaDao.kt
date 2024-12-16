package com.example.activity11.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.activity11.data.entity.Mahasiswa

@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
}