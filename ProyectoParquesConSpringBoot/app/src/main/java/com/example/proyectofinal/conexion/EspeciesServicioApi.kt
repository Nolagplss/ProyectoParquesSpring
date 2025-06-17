package com.example.proyectofinal.conexion

import com.example.proyectofinal.modelo.Especies
import com.example.proyectofinal.modelo.Parques
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface EspeciesServicioApi {

    @GET("especies")
    suspend fun obtenerEspecies(): List<Especies>

    @POST("especies")
    suspend fun insertarEspecie(
        @Body especies: Especies
    ): Especies

    @PUT("especies/{id}")
    suspend fun actualizarEspecie(
        @Path("id") id: Int,
        @Body especies: Especies
    ): Especies

    @DELETE("especies/{id}")
    suspend fun eliminarEspecie(
        @Path("id") id: Int
    ): Response<Unit>?

    @GET("especies/{id}")
    suspend fun buscarEspeciePorId(@Path("id") id: Int): Especies


}