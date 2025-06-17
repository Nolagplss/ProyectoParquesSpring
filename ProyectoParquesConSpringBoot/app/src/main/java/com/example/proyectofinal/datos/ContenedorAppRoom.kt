package com.example.proyectofinal.datos

import android.content.Context
import com.example.proyectofinal.conexion.ParquesRoomBaseDatos

interface ContenedorAppRoom {
    val parquesRoomRepositorio: ParquesRoomRepositorio
}

class ParquesRoomContenedorApp(private val context: Context) : ContenedorAppRoom {

    override val parquesRoomRepositorio: ParquesRoomRepositorio by lazy {
        ConexionParquesRoomRepositorio(ParquesRoomBaseDatos.obtenerParquesRoomBaseDatos(context).parquesRoomDao())
    }
}