package com.example.proyectofinal.datos

import com.example.proyectofinal.conexion.ParquesServicioApi
import com.example.proyectofinal.modelo.Parques

interface ParquesRepositorio{
    suspend fun obtenerParques(): List<Parques>
    suspend fun insertarParque(parques: Parques): Parques
    suspend fun actualizarParque(id: Int, parques: Parques): Parques
    suspend fun eliminarParque(id: Int): Unit

}

class ConexionParqueRepositorio(
    private val parqueServicioApi: ParquesServicioApi,

): ParquesRepositorio{
    override suspend fun obtenerParques(): List<Parques> {
        val parques = parqueServicioApi.obtenerParques()
        parques.forEach {
            println("Parque recibido con especies: ${it.listaEspecies}")
        }
        return parques
    }    override suspend fun insertarParque(parques: Parques): Parques = parqueServicioApi.insertarParque(parques)
    override suspend fun actualizarParque(id: Int, parques: Parques ): Parques = parqueServicioApi.actualizarParque(id, parques)
    override suspend fun eliminarParque(id: Int): Unit {
        val response = parqueServicioApi.eliminarParque(id)
        if (response != null && response.isSuccessful) {
            println("Parque eliminado correctamente")
        } else {
            println("Error al eliminar el parque: ${response?.errorBody()}")
        }
    }

}