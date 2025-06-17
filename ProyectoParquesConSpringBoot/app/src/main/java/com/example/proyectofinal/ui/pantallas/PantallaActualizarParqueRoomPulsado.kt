package com.example.proyectofinal.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.proyectofinal.modelo.ParquesRoom

@Composable
fun PantallaActualizarParqueRoomPulsado(
    parquesRoom: ParquesRoom,
    onParquesRoomActualizado: (ParquesRoom) -> Unit,
    modifier: Modifier = Modifier
)
{

    var nombre by remember { mutableStateOf("") }
    var cantidadEspecies by remember { mutableStateOf("") }
    var cantidadEspeciesInt by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Spacer(Modifier.height(16.dp))

        TextField(
            value = parquesRoom.id.toString(),
            label = { Text(text = "Id") },
            onValueChange = {},
            enabled = false
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = nombre,
            label = { Text(text = stringResource(R.string.nombre)) },
            onValueChange = { nombre = it }
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = cantidadEspecies,
            label = { Text(text = stringResource(R.string.cantidad_especies)) },
            onValueChange = { cantidadEspecies = it }
        )
        cantidadEspeciesInt = cantidadEspecies.toIntOrNull() ?: 0

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                val parquesRoomActualizado = ParquesRoom(
                    id = parquesRoom.id,
                    nombreParque = nombre,
                    cantEspecies = cantidadEspeciesInt

                )
                onParquesRoomActualizado(parquesRoomActualizado)
            }) {
            Text(text = stringResource(R.string.actualizar))
        }
    }
}