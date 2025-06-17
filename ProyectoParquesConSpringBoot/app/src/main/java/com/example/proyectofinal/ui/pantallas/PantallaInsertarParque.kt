package com.example.proyectofinal.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import com.example.proyectofinal.modelo.ParquesRoom
import com.example.proyectofinal.ui.EspeciesUIState
import com.example.proyectofinal.ui.EspeciesViewModel

@Composable
fun PantallaInsertarParque(
    onInsertarParquePulsado: (Parques) -> Unit,
    onInsertarParqueEnRoom: (ParquesRoom) -> Unit,
    modifier: Modifier = Modifier,
    onBuscarEspecieId: (Int) -> Unit,
    viewModelEspecies: EspeciesViewModel,
){

    var nombreParque by remember { mutableStateOf("") }
    var extensionParque by remember { mutableStateOf("") }
    var extensionParqueDouble by remember { mutableStateOf(0.0) }



    var chekeadoEspecies by remember { mutableStateOf(false) }
    var pusoCantEspecies by remember { mutableStateOf(false) }

    var idEspecieBuscar by remember { mutableStateOf("") }
    var idEspecieBuscarInt by remember { mutableStateOf(0) }



    var listaEspecies by remember { mutableStateOf(listOf<Especies>()) }

    // Observamos el estado del ViewModel

    val especieEncontrada = viewModelEspecies.especieBuscada

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Spacer(Modifier.height(16.dp))


        TextField(
            value = nombreParque,
            label = { Text(text = stringResource(R.string.nombre_parque)) },
            onValueChange = { nombreParque = it }
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = extensionParque,
            label = { Text(text = stringResource(R.string.extension_del_parque)) },
            onValueChange = { extensionParque = it }
        )

        extensionParqueDouble = extensionParque.toDoubleOrNull() ?: 0.0

        Spacer(Modifier.height(16.dp))

        //QUieres ingresar especies?
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(R.string.ingresar_especies)
            )
            Checkbox(
                checked = chekeadoEspecies,
                onCheckedChange = { chekeadoEspecies = it }
            )
        }
        Spacer(Modifier.height(16.dp))


        //SI quiere especies
        if(chekeadoEspecies){





            //Pedimos que ingrese el nombre de alguna
            TextField(
                value = idEspecieBuscar,
                label = { Text(text = stringResource(R.string.id_de_la_especie)) },
                onValueChange = { idEspecieBuscar = it }
            )

            idEspecieBuscarInt = idEspecieBuscar.toIntOrNull()?: 0


                    //-BUSCAR ESPECIE---------------------------------------
            //Buscamos la especie en el json

            // Botón para buscar la especie por nombre
            Button(onClick = { onBuscarEspecieId(idEspecieBuscarInt) }) {
                Text(text = stringResource(R.string.buscar_especie))
            }


            println("Especie despues de clickar " + idEspecieBuscarInt)


            // Mostrar la especie encontrada
            especieEncontrada?.let { especie ->
                Text(text = stringResource(R.string.especie_encontrada, especie.nombre))

                Button(onClick = {
                    listaEspecies = listaEspecies + especie

                }) {
                    Text(stringResource(R.string.agregar_especie))
                }
            } ?: Text(stringResource(R.string.especie_no_encontrada))





            println("Nombre Especie  de buscarla " + especieEncontrada?.nombre)


            Spacer(Modifier.height(16.dp))


            //GUARDAMOS PARUQE CON ESPECIE----------------------------
            println("Estado de chekeadoEspecies: $chekeadoEspecies")
            println("Tamaño de listaEspecies: ${listaEspecies.size}")




        }
        if(chekeadoEspecies == false && nombreParque.isNotEmpty() && extensionParque.isNotEmpty()){

            Button(
                onClick = {
                    val parques = Parques(
                        nombre = nombreParque,
                        extension = extensionParqueDouble,
                        listaEspecies = listaEspecies
                    )
                    onInsertarParquePulsado(parques)

                    val parqueRoom = ParquesRoom(
                        nombreParque = nombreParque,
                        cantEspecies = listaEspecies?.size ?: 0
                    )

                    onInsertarParqueEnRoom(parqueRoom)
                }
            ) {
                Text(text = stringResource(R.string.insertar_parque))
            }


        }

        if(chekeadoEspecies && listaEspecies.isNotEmpty()){
            Button(
                onClick = {
                    val parques = Parques(
                        nombre = nombreParque,
                        extension = extensionParqueDouble,
                        listaEspecies = listaEspecies
                    )
                    onInsertarParquePulsado(parques)

                    val parqueRoom = ParquesRoom(
                        nombreParque = nombreParque,
                        cantEspecies = listaEspecies?.size ?: 0
                    )

                    onInsertarParqueEnRoom(parqueRoom)
                }
            ) {
                Text(text = stringResource(R.string.insertar_parque))
            }
        }






    }

}