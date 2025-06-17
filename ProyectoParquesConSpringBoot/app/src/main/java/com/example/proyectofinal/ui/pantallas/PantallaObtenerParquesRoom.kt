package com.example.proyectofinal.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyectofinal.R
import com.example.proyectofinal.modelo.ParquesRoom
import com.example.proyectofinal.ui.ParquesRoomUIState


@Composable
fun PantallaObtenerParquesRoom(
    appUIState: ParquesRoomUIState,
    onParquesRoomObtenidos: () -> Unit,
    onParquesRoomPulsado: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    when (appUIState) {
        is ParquesRoomUIState.CargandoParquesRoom -> PantallaCargando(modifier = modifier.fillMaxSize())
        is ParquesRoomUIState.ErrorParquesRoom -> PantallaError(modifier = modifier.fillMaxWidth())
        is ParquesRoomUIState.ObtenerParquesRoomExitoTodos -> PantallaObtenerListaParquesRoom(
            lista = appUIState.parquesRoom,
            onParquesRoomPulsado = onParquesRoomPulsado,
            modifier = modifier.fillMaxWidth()
        )
        is ParquesRoomUIState.ObtenerParquesRoomExito -> onParquesRoomObtenidos()
        is ParquesRoomUIState.CrearParquesRoomExito -> onParquesRoomObtenidos()
        is ParquesRoomUIState.ActualizarParquesRoomExito -> onParquesRoomObtenidos()
    }
}

@Composable
fun PantallaCargando(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.cargando),
        contentDescription = "Cargando"
    )
}

@Composable
fun PantallaError(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.error),
        contentDescription = "error"
    )
}

@Composable
fun PantallaObtenerListaParquesRoom(
    lista: List<ParquesRoom>,
    onParquesRoomPulsado: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier) {
        items(lista){ parquesRoom ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable(
                        onClick = { onParquesRoomPulsado(parquesRoom.id) }
                    )
            ){
                Column(
                    modifier= Modifier.fillMaxWidth()
                ){
                    Text(
                        text = parquesRoom.nombreParque
                    )
                    Text(
                        text = parquesRoom.cantEspecies.toString()
                    )

                    HorizontalDivider()
                }

            }
        }
    }
}