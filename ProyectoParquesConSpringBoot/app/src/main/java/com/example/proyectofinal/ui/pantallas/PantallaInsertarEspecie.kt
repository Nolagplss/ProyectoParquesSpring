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

@Composable
fun PantallaInsertarEspecie(
    onInsertarEspeciePulsada: (Especies) -> Unit,
    modifier: Modifier = Modifier

){

    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Spacer(Modifier.height(16.dp))

        TextField(
            value = nombre,
            label = { Text(text = stringResource(R.string.nombre)) },
            onValueChange = { nombre = it }
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = descripcion,
            label = { Text(text = stringResource(R.string.descripcion_especie)) },
            onValueChange = { descripcion = it }
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = tipo,
            label = { Text(text = stringResource(R.string.tipo_especie)) },
            onValueChange = { tipo = it }
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                val especie = Especies(
                    nombre = nombre,
                    descripcion = descripcion,
                    tipo = tipo
                )
                onInsertarEspeciePulsada(especie)
            }
        ) {
            Text(text = stringResource(R.string.insertar_especie))
        }
    }

}