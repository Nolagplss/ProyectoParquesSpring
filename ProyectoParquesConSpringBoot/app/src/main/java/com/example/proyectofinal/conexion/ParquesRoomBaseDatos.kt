package com.example.proyectofinal.conexion

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.proyectofinal.dao.ParquesRoomDao
import com.example.proyectofinal.modelo.ParquesRoom


@Database(entities = [ParquesRoom::class], version = 1, exportSchema = false)
abstract class ParquesRoomBaseDatos: RoomDatabase() {

    abstract fun parquesRoomDao(): ParquesRoomDao

    companion object {
        @Volatile
        private var Instance: ParquesRoomBaseDatos? = null

        fun obtenerParquesRoomBaseDatos(context: Context): ParquesRoomBaseDatos {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ParquesRoomBaseDatos::class.java, "parquesRoomBd")
                    .build()
                    .also { Instance = it }
            }
        }
    }


}
