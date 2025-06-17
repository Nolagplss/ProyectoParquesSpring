package com.example.proyectofinal

import android.app.Application
import com.example.proyectofinal.datos.ParquesContenedorApp
import com.example.proyectofinal.datos.ParquesRoomContenedorApp

class ParquesAplicacion : Application() {
    val contenedorParques by lazy{ ParquesContenedorApp()}
    val contenedorParquesRoom by lazy{ ParquesRoomContenedorApp(this)}
}