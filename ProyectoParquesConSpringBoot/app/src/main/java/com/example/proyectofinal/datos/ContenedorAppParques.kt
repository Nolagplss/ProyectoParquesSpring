package com.example.proyectofinal.datos

import com.example.proyectofinal.conexion.EspeciesServicioApi
import com.example.proyectofinal.conexion.ParquesServicioApi
import com.example.proyectofinal.modelo.Parques
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface ContenedorAppParques{
    val parquesRepositorio: ParquesRepositorio
    val especiesRepositorio: EspeciesRepositorio
}

class ParquesContenedorApp : ContenedorAppParques{
    private val baseUrl = "http://192.168.1.14:8080/api/"


    // Configuramos Json para ignorar claves desconocidas
    private val json = Json { ignoreUnknownKeys = true
    coerceInputValues = true // por si hay algun nulo que ponga por defecto un valor
    }

    // Construimos el cliente Retrofit
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType())) // Convertidor de JSON
        .baseUrl(baseUrl)
        .build()

    // Inicialización perezosa del servicio Retrofit
    private val servicioRetrofit: ParquesServicioApi by lazy {
        retrofit.create(ParquesServicioApi::class.java)
    }

    private val servicioRetrofitEspecie: EspeciesServicioApi by lazy{
        retrofit.create(EspeciesServicioApi::class.java)
    }

    // Proporcionamos el repositorio de parques
    override val parquesRepositorio: ParquesRepositorio by lazy {
        ConexionParqueRepositorio(servicioRetrofit)
    }

    override val especiesRepositorio: EspeciesRepositorio by lazy{
        ConexionEspecieRepositorio(servicioRetrofitEspecie)
    }

}