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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.proyectofinal.R
import com.example.proyectofinal.modelo.Especies
import com.example.proyectofinal.ui.EspeciesUIState

@Composable
fun PantallaObtenerEspecies(
    appUIState: EspeciesUIState,
    onEspeciesObtenidas: () -> Unit,
    onEspecieEliminada: (Int) -> Unit,
    onEspeciePulsada: (Especies) -> Unit
)
    {

        when(appUIState){
            is EspeciesUIState.CargarEspecie -> PantallaCargarEspecie(modifier = Modifier.fillMaxSize())
            is EspeciesUIState.ErrorEspecie -> PantallaErrorEspecie(modifier = Modifier.fillMaxWidth())
            is EspeciesUIState.ObtenerEspecieExito -> PantallaListarEspecies(
                lista =appUIState.especies,
                modifier = Modifier.fillMaxWidth(),
                onEspecieEliminada =onEspecieEliminada,
                onEspeciePulsada = onEspeciePulsada

            )
            is EspeciesUIState.CrearEspecieExito -> onEspeciesObtenidas()
            is EspeciesUIState.BuscarEspecieExito -> onEspeciesObtenidas()
            is EspeciesUIState.ErrorBuscarEspecie -> onEspeciesObtenidas()
            is EspeciesUIState.EliminarEspecieExito -> onEspeciesObtenidas()
            is EspeciesUIState.ActualizarEspecieExito -> onEspeciesObtenidas()
        }


    }




@Composable
fun PantallaCargarEspecie(
    modifier: Modifier = Modifier
){

    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.cargando),
        contentDescription = "cargando"
    )

}

@Composable
fun PantallaErrorEspecie(
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
fun PantallaListarEspecies(
    lista: List<Especies>,
    modifier: Modifier = Modifier,
    onEspecieEliminada: (Int) -> Unit,
    onEspeciePulsada: (Especies) -> Unit
) {

    LazyColumn(modifier = modifier) {
        items(lista) { especie ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .combinedClickable(
                        onClick = { onEspeciePulsada(especie) },
                        onLongClick = { onEspecieEliminada(especie.id) }
                    )
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "ID: ${especie.id}")
                    Text(text = stringResource(R.string.nombre) + " " + especie.nombre)
                    Text(text = stringResource(R.string.descripcion_especie) + " " + especie.descripcion)
                    Text(text = stringResource(R.string.tipo_especie)+ " " + especie.tipo)


                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))


                }

            }
        }


    }
}