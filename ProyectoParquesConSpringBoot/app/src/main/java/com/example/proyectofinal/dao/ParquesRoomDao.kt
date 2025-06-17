package com.example.proyectofinal.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.proyectofinal.modelo.ParquesRoom

@Dao
interface ParquesRoomDao {

    @Query("SELECT * from ParquesRoom WHERE id = :id")
    suspend fun obtenerParquesRoom(id: Int): ParquesRoom

    @Query("SELECT * from ParquesRoom ORDER BY nombreParque ASC")
    suspend fun obtenerTodosParquesRoom(): List<ParquesRoom>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertarParqueRoom(parquesRoom: ParquesRoom)

    @Update
    suspend fun actualizarParqueRoom(parquesRoom: ParquesRoom)

    @Delete
    suspend fun elimianrParqueRoom(parquesRoom: ParquesRoom)
}