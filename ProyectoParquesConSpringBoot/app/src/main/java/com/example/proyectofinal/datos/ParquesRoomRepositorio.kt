package com.example.proyectofinal.datos

import com.example.proyectofinal.dao.ParquesRoomDao
import com.example.proyectofinal.modelo.ParquesRoom


interface ParquesRoomRepositorio {
    suspend fun obtenerParquesRoom(id: Int): ParquesRoom
    suspend fun obtenerTodosParquesRoom(): List<ParquesRoom>
    suspend fun insertarParqueRoom(parquesRoom: ParquesRoom)
    suspend fun actualizarParqueRoom(parquesRoom: ParquesRoom)
    suspend fun eliminarParqueRoom(parquesRoom: ParquesRoom)
}

class ConexionParquesRoomRepositorio(
    private val parquesRoomDao: ParquesRoomDao
): ParquesRoomRepositorio {
    override suspend fun obtenerParquesRoom(id: Int): ParquesRoom = parquesRoomDao.obtenerParquesRoom(id)
    override suspend fun obtenerTodosParquesRoom(): List<ParquesRoom> = parquesRoomDao.obtenerTodosParquesRoom()
    override suspend fun insertarParqueRoom(parquesRoom: ParquesRoom ) = parquesRoomDao.insertarParqueRoom(parquesRoom)
    override suspend fun actualizarParqueRoom(parquesRoom: ParquesRoom) = parquesRoomDao.actualizarParqueRoom(parquesRoom)
    override suspend fun eliminarParqueRoom(parquesRoom: ParquesRoom) = parquesRoomDao.elimianrParqueRoom(parquesRoom)
}