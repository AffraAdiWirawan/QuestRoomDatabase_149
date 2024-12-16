package com.example.activity11.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.activity11.data.entity.Mahasiswa

@Dao
interface MahasiswaDao {

    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa(): Flow<List<Mahasiswa>>

    @Query("SELECT * FROM mahasiswa WHERE nim = :nim")
    fun  getMahasiswa(nim: String): Flow<Mahasiswa>

    @Delete
    suspend fun deleteMahasiswa(mahasiswa: Mahasiswa)

    @Update
    suspend fun updateMahasiswa(mahasiswa: Mahasiswa)
}