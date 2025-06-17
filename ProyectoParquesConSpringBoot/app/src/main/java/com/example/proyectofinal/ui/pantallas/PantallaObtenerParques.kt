package com.example.proyectofinal.ui.pantallas

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.proyectofinal.R
import com.example.proyectofinal.modelo.Parques
import com.example.proyectofinal.ui.ParquesUIState


@Composable
fun PantallaObtenerParques(
    appUIState: ParquesUIState,
    onParqueObtenido:() -> Unit,
    onParqueSeleccionado: (Parques) -> Unit,
    onParqueEliminado: (Int) -> Unit
){

    when(appUIState){
        is ParquesUIState.CargandoParque -> PantallaCargarParque(modifier = Modifier.fillMaxSize())
        is ParquesUIState.ErrorParque -> PantallaErrorParque(modifier = Modifier.fillMaxWidth())
        is ParquesUIState.ObtenerParqueExito -> PantallaListarParques(
            lista =appUIState.parques,
            modifier = Modifier.fillMaxWidth(),
            onParqueSeleccionado = onParqueSeleccionado,
            onParqueEliminado = onParqueEliminado

        )
        is ParquesUIState.EliminarParqueExito -> onParqueObtenido()
        is ParquesUIState.ActualizarParqueExito ->onParqueObtenido()
        is ParquesUIState.CrearParqueExito -> onParqueObtenido()
    }


}


@Composable
fun PantallaCargarParque(
modifier: Modifier = Modifier
){

    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.cargando),
        contentDescription = "cargando"
    )

}

@Composable
fun PantallaErrorParque(
modifier: Modifier = Modifier
){
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.error),
        contentDescription = "error"
    )

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PantallaListarParques(
    lista: List<Parques>,
    modifier: Modifier = Modifier,
    onParqueSeleccionado: (Parques) -> Unit,
    onParqueEliminado: (Int) -> Unit
) {

    LazyColumn(modifier = modifier) {
        items(lista) { parque ->

            var desplegarEspecies by remember { mutableStateOf(false) }

            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .combinedClickable(
                        onClick = { onParqueSeleccionado(parque) },
                        onLongClick = { onParqueEliminado(parque.id) }
                    )
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "ID: ${parque.id}")
                    Text(text = stringResource(R.string.nombre_parque) + " " + parque.nombre)
                    Text(text = stringResource(R.string.extension) + " " + parque.extension)

                    Button(
                        onClick = {
                            desplegarEspecies = !desplegarEspecies
                        },
                        modifier = Modifier.padding(top = 8.dp)


                    ) {
                        Text(text = stringResource(R.string.mostrar_especies))
                    }

                    // Aquí puedes agregar el println para depurar
                    println("Especies para el parque ${parque.id}: ${parque.listaEspecies}")

                    //Si es verdadero mostrarlas
                    if (desplegarEspecies) {

                        val especiesLista =
                            parque.listaEspecies ?: emptyList() //Evitar null con una lista vacía

                        if (especiesLista.isEmpty()) {
                            Text(text = stringResource(R.string.no_tiene_especies))
                        } else {
                            parque.listaEspecies?.forEach { especie ->

                                Column(modifier = Modifier.padding(start = 16.dp, top = 4.dp)) {
                                    Text(text = "ID: ${especie.id}")
                                    Text(text =  stringResource(R.string.nombre_especie)+ " " + especie.nombre)
                                    Text(text = stringResource(R.string.tipo_especie)+ " " + especie.tipo)
                                    Text(text = stringResource(R.string.descripcion_especie)+ " " + especie.descripcion)
                                }
                            }
                        }


                    }



                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                }

            }
        }


    }
}

