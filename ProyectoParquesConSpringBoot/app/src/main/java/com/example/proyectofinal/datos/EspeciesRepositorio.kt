package com.example.proyectofinal.datos

import com.example.proyectofinal.conexion.EspeciesServicioApi
import com.example.proyectofinal.conexion.ParquesServicioApi
import com.example.proyectofinal.modelo.Especies
import com.example.proyectofinal.modelo.Parques

interface EspeciesRepositorio {
    suspend fun obtenerEspecies(): List<Especies>
    suspend fun insertarEspecie(especies: Especies): Especies
    suspend fun actualizarEspecie(id: Int, especies: Especies): Especies
    suspend fun eliminarEspecie(id: Int): Unit
    suspend fun buscarEspeciePorId(id: Int): Especies?

}


class ConexionEspecieRepositorio(
    private val especieServicioApi: EspeciesServicioApi
): EspeciesRepositorio{
    override suspend fun obtenerEspecies(): List<Especies> = especieServicioApi.obtenerEspecies()
    override suspend fun insertarEspecie(especies: Especies): Especies = especieServicioApi.insertarEspecie(especies)
    override suspend fun actualizarEspecie(id: Int, especies: Especies): Especies = especieServicioApi.actualizarEspecie(id, especies)
    override suspend fun eliminarEspecie(id: Int): Unit {
        val response = especieServicioApi.eliminarEspecie(id)
        if (response != null && response.isSuccessful) {
            println("Especie eliminada correctamente")
        } else {
            println("Error al eliminar la especie: ${response?.errorBody()}")
        }
    }

    override suspend fun buscarEspeciePorId(id: Int): Especies? {
        return try {
            val especie = especieServicioApi.buscarEspeciePorId(id)  // Cambié el parámetro para que sea por ID
            if (especie != null) {
                println("Especie encontrada: ${especie.nombre}")
            } else {
                println("No se encontró la especie con el ID: $id")
            }
            especie
        } catch (e: Exception) {
            println("Error al buscar la especie por ID: ${e.message}")
            null  // Si hay un error, retornamos null
        }
    }

}