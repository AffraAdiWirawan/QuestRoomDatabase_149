package com.example.activity11.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.activity11.data.dao.MahasiswaDao
import com.example.activity11.data.entity.Mahasiswa

// Mendefinisikan database dengan tabel mahasiswa
@Database(entities = [Mahasiswa::class], version =1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase(){
    abstract fun mahasiswaDao(): MahasiswaDao
    // Mendefinisikan fungsi untuk mengakses data mahasiswa
    companion object{
        @Volatile
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDatabase::class.java,
                    "KrsDatabase"
                )
                    .build().also {Instance = it}
            })

        }
    }
}