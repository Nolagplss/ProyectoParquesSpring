package com.example.proyectofinal.modelo

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerMenu (
    val icono: ImageVector,
    @StringRes val titulo: Int,
    val ruta: String
)