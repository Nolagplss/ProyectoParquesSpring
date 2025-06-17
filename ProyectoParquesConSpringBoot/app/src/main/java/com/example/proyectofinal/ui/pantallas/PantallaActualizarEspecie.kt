package com.example.proyectofinal.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.proyectofinal.R
import com.example.proyectofinal.modelo.Especies
import com.example.proyectofinal.modelo.Parques

@Composable
fun PantallaActualizarEspecie(
    especies: Especies,
    onEspecieActualizada: (Especies) -> Unit,
    modifier: Modifier = Modifier
){

    var nombreEspecies by remember { mutableStateOf("") }
    var descripcionEspecies by remember { mutableStateOf("") }
    var tipoEspecies by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Spacer(Modifier.height(16.dp))

        // Mostramos el id, pero como no se debe editar, está deshabilitado
        TextField(
            value = especies.id.toString(),
            label = { Text(text = "ID") },
            onValueChange = {},
            enabled = false
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = nombreEspecies,
            label = { Text(text = stringResource(R.string.nombre_especie)) },
            onValueChange = { nombreEspecies = it }
        )


        Spacer(Modifier.height(8.dp))

        TextField(
            value = descripcionEspecies,
            label = { Text(text = stringResource(R.string.descripcion_especie)) },
            onValueChange = { descripcionEspecies = it }
        )

        Spacer(Modifier.height(8.dp))

        TextField(
            value = tipoEspecies,
            label = { Text(text = stringResource(R.string.tipo_especie)) },
            onValueChange = { tipoEspecies = it }
        )

        // Botón para confirmar la actualización
        Button(
            onClick = {
                // Crear un nuevo objeto con los datos modificados
                val especieActualizada = Especies(
                    id = especies.id,
                    nombre = nombreEspecies,
                    descripcion = descripcionEspecies,
                    tipo = tipoEspecies
                )
                // Llamar al callback para pasar la actualizada
                onEspecieActualizada(especieActualizada)
            }
        ) {
            Text(text = stringResource(R.string.actualizar))
        }

    }

}