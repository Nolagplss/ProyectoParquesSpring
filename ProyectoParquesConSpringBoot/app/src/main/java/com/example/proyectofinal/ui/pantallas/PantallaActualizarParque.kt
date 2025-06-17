package com.example.proyectofinal.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
fun PantallaActualizarParque(
    parques: Parques,
    onParqueActualizado: (Parques) -> Unit,
    modifier: Modifier = Modifier
) {


    var nombre by remember { mutableStateOf("") }
    var extension by remember { mutableStateOf("") }
    var extensionDouble by remember { mutableStateOf(0.0) }

    val listaEspecies = remember { mutableStateListOf<Especies>() }





    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Spacer(Modifier.height(16.dp))

        // Mostramos el id, pero como no se debe editar, está deshabilitado
        TextField(
            value = parques.id.toString(),
            label = { Text(text = "ID") },
            onValueChange = {},
            enabled = false
        )

        Spacer(Modifier.height(16.dp))

        // Campo para editar el título de la película
        TextField(
            value = nombre,
            label = { Text(text = stringResource(R.string.nombre)) },
            onValueChange = { nombre = it }
        )

        Spacer(Modifier.height(16.dp))

        // Campo para editar el autor
        TextField(
            value = extension,
            label = { Text(text = stringResource(R.string.extension)) },
            onValueChange = { extension = it }
        )
        extensionDouble = extension.toDoubleOrNull() ?: 0.0

        Spacer(Modifier.height(16.dp))

        //Si es distinto de no haber especie o es nula que muestre las especies
        if (!parques.listaEspecies.isNullOrEmpty()) {

            //foreach para editar especies
            parques.listaEspecies.forEachIndexed { index, especie ->
                Spacer(Modifier.height(16.dp))

                var nombreEspecies by remember { mutableStateOf("") }
                var descripcionEspecies by remember { mutableStateOf("") }
                var tipoEspecies by remember { mutableStateOf("") }

                Text(text = "Especie ${index + 1}", modifier = Modifier.align(Alignment.Start))

                TextField(
                    value = nombreEspecies,
                    label = { Text(text = stringResource(R.string.nombre_especie)) },
                    onValueChange = { nombreEspecies = it }
                )


                Spacer(Modifier.height(8.dp))

                TextField(
                    value = descripcionEspecies,
                    label = { Text(text = stringResource(R.string.tipo_especie)) },
                    onValueChange = { descripcionEspecies = it }
                )

                Spacer(Modifier.height(8.dp))

                TextField(
                    value = tipoEspecies,
                    label = { Text(text = stringResource(R.string.tipo_especie)) },
                    onValueChange = { tipoEspecies = it }
                )
                //Creamos objeto especie
                val especie = Especies(
                    nombre = nombreEspecies,
                    descripcion = descripcionEspecies,
                    tipo = tipoEspecies
                )

                //Guardamos objeto en lista local
                listaEspecies.add(especie)


            }
        }
        // Botón para confirmar la actualización
        Button(
            onClick = {
                // Crear un nuevo objeto con los datos modificados
                val parqueActualizado = Parques(
                    id = parques.id,
                    nombre = nombre,
                    extension = extensionDouble,
                    listaEspecies = listaEspecies
                )
                // Llamar al callback para pasar la actualizada
                onParqueActualizado(parqueActualizado)
            }
        ) {
            Text(text = stringResource(R.string.actualizar))
        }
    }





}


