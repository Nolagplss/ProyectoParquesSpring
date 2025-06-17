package com.example.proyectofinal.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ParquesRoom")
data class ParquesRoom(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombreParque: String = "",
    val cantEspecies: Int = 0

)