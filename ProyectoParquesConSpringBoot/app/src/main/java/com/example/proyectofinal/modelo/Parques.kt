package com.example.proyectofinal.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Parques
    (

    @SerialName(value = "id")
    val id: Int = 0,
    @SerialName(value = "nombre")
    val nombre: String = "",
    @SerialName(value = "extension")
    val extension: Double = 0.0,
    @SerialName(value = "especies")
    val listaEspecies: List<Especies> = listOf() // Lista de especies asociadas al parque
)