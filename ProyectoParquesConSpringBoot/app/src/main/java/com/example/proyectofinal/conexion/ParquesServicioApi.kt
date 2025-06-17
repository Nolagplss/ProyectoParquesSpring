package com.example.proyectofinal.conexion

import com.example.proyectofinal.modelo.Parques
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ParquesServicioApi {

    @GET("parques")
    suspend fun obtenerParques(): List<Parques>

    @POST("parques")
    suspend fun insertarParque(
        @Body parques: Parques
    ): Parques

    @PUT("parques/{id}")
    suspend fun actualizarParque(
        @Path("id") id: Int,
        @Body parques: Parques
    ): Parques

    @DELETE("parques/{id}")
    suspend fun eliminarParque(
        @Path("id") id: Int
    ): Response<Unit>?



}