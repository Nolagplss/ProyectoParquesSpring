package com.example.proyectofinal.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.proyectofinal.R
import com.example.proyectofinal.modelo.DrawerMenu
import com.example.proyectofinal.modelo.Ruta
import com.example.proyectofinal.ui.pantallas.PantallaActualizarEspecie
import com.example.proyectofinal.ui.pantallas.PantallaActualizarParque
import com.example.proyectofinal.ui.pantallas.PantallaInsertarEspecie
import com.example.proyectofinal.ui.pantallas.PantallaInsertarParque
import com.example.proyectofinal.ui.pantallas.PantallaActualizarParqueRoomPulsado
import com.example.proyectofinal.ui.pantallas.PantallaObtenerEspecies
import com.example.proyectofinal.ui.pantallas.PantallaObtenerParques
import com.example.proyectofinal.ui.pantallas.PantallaObtenerParquesRoom
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


enum class Pantallas(@StringRes val titulo: Int) {
    InicioParques(titulo = (R.string.obtener_parques)),
    InsertarParques(titulo = (R.string.insertarparques)),
    ActualizarParque(titulo = (R.string.actualizar_parque)),
    InsertarEspecie(titulo = (R.string.insertarespecie)),
    ObtenerEspecie(titulo = (R.string.obtenerespecies)),
    ActualizarEspecie(titulo = (R.string.actualizar_especie)),
    ObtenerParquesRoom(titulo = (R.string.registro_de_parques_insertados)),
    ActualizarParqueRoom(titulo = (R.string.actualizar_parque_room))

}


val listaRutas = listOf(
    Ruta(Pantallas.InicioParques.titulo, Pantallas.InicioParques.name,
        Icons.Filled.Check, Icons.Outlined.List),

    Ruta(Pantallas.ObtenerEspecie.titulo, Pantallas.ObtenerEspecie.name,
         Icons.Filled.Check, Icons.Outlined.List)
)

val menu = arrayOf(
    DrawerMenu(Icons.Filled.Add, Pantallas.InsertarParques.titulo,
        Pantallas.InsertarParques.name
    ),
    DrawerMenu(Icons.Filled.Add, Pantallas.InsertarEspecie.titulo,
        Pantallas.InsertarEspecie.name
    ),
    DrawerMenu(Icons.Filled.Menu, Pantallas.ObtenerParquesRoom.titulo,
        Pantallas.ObtenerParquesRoom.name
    )


)


@Composable
fun PantallaGeneral(
    viewModelParques: ParquesViewModel = viewModel(factory = ParquesViewModel.Factory),
    viewModelEspecies: EspeciesViewModel = viewModel(factory = EspeciesViewModel.Factory),
    viewModelParquesRoom: ParquesRoomViewModel = viewModel(factory = ParquesRoomViewModel.Factory),
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    )
{
    val pilaRetroceso by navController.currentBackStackEntryAsState()

    val pantallaActual = Pantallas.valueOf(
        pilaRetroceso?.destination?.route ?: Pantallas.InicioParques.name
    )

    var selectedItem by remember { mutableIntStateOf(0) }


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent(
                    menu = menu,
                    pantallaActual = pantallaActual
                ) { ruta ->
                    coroutineScope.launch {
                        drawerState.close()
                    }

                    navController.navigate(ruta)
                }
            }
        },
    ) {


        Scaffold(
            topBar = {
                AppTopBar(
                    pantallaActual = pantallaActual,
                    puedeNavegarAtras = navController.previousBackStackEntry != null,
                    onNavegarAtras = { navController.navigateUp() }
                )
            },
            bottomBar = {
                NavigationBar {
                    listaRutas.forEachIndexed { indice, ruta ->

                        NavigationBarItem(
                            icon = {
                                // Si el ítem está seleccionado, muestra el icono lleno, sino, el icono vacío.
                                Icon(
                                    imageVector = if (selectedItem == indice) ruta.iconoLleno else ruta.iconoVacio,
                                    contentDescription = ("si") // O lo que sea que quieras aquí
                                )
                            },
                            label = { Text(stringResource(id = ruta.nombre)) },  // Mostrar el texto del label correspondiente
                            selected = selectedItem == indice,
                            onClick = {
                                // Al hacer clic, cambia el valor de selectedItem y navega a la ruta correspondiente
                                selectedItem = indice
                                navController.navigate(ruta.ruta)
                            }
                        )

                    }
                }

            },



        ) { innerPadding ->

            val uiStateParques = viewModelParques.parqueUIState
            val uiStateEspecies = viewModelEspecies.especieUIState
            val uiStateParquesRoom = viewModelParquesRoom.parquesRoomUIState

            NavHost(
                navController = navController,
                startDestination = Pantallas.InicioParques.name,
                modifier = Modifier.padding(innerPadding)
            ) {

                composable(route = Pantallas.InicioParques.name) {
                    PantallaObtenerParques(

                        onParqueObtenido = {
                            viewModelParques.obtenerParques()
                        },
                        appUIState = uiStateParques,
                        onParqueSeleccionado = {
                            viewModelParques.actualizarParquePulsado(it)
                            navController.navigate(Pantallas.ActualizarParque.name)
                        },
                        onParqueEliminado = { viewModelParques.eliminarParque(it) },


                        )
                }


                composable(route = Pantallas.InsertarParques.name) {
                    PantallaInsertarParque(
                        onInsertarParquePulsado = {
                            viewModelParques.insertarParque(it)
                            navController.popBackStack(
                                Pantallas.InicioParques.name,
                                inclusive = false
                            )

                        },
                        onInsertarParqueEnRoom = {
                            viewModelParquesRoom.insertarParqueRoom(it)
                            navController.popBackStack(
                            Pantallas.InicioParques.name,
                            inclusive = false
                            )
                        },
                        modifier = Modifier
                            .fillMaxSize(),

                        onBuscarEspecieId = {
                            viewModelEspecies.buscarEspeciePorNombre(it)
                        },


                        viewModelEspecies = viewModelEspecies,


                        )


                }


                composable(route = Pantallas.ActualizarParque.name) {
                    PantallaActualizarParque(
                        parques = viewModelParques.parquePulsado,
                        onParqueActualizado = {
                            viewModelParques.actualizarParque(it.id, it)
                            navController.popBackStack(
                                Pantallas.InicioParques.name,
                                inclusive = false
                            )
                        },
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                composable(route = Pantallas.InsertarEspecie.name) {
                    PantallaInsertarEspecie(
                        onInsertarEspeciePulsada = {
                            viewModelEspecies.insertarEspecie(it)
                            navController.navigate(Pantallas.ObtenerEspecie.name) {
                                popUpTo(Pantallas.ObtenerEspecie.name) { inclusive = false }
                            }
                        },
                        modifier = Modifier
                            .fillMaxSize(),

                        )
                }

                composable(route = Pantallas.ObtenerEspecie.name) {
                    PantallaObtenerEspecies(
                        onEspeciesObtenidas = {
                            viewModelEspecies.obtenerEspecies()
                        },
                        appUIState = uiStateEspecies,
                        onEspeciePulsada = {
                            viewModelEspecies.actualizarEspeciePulsada(it)
                            navController.navigate(Pantallas.ActualizarEspecie.name)
                        },
                        onEspecieEliminada = { viewModelEspecies.eliminarEspecie(it) },

                        )
                }

                composable(route = Pantallas.ActualizarEspecie.name) {
                    PantallaActualizarEspecie(
                        especies = viewModelEspecies.especiePulsada,
                        onEspecieActualizada = {
                            viewModelEspecies.actualizarEspecie(it.id, it)
                            navController.popBackStack(
                                Pantallas.ObtenerEspecie.name,
                                inclusive = false
                            )

                        },
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                composable(route = Pantallas.ObtenerParquesRoom.name) {
                    PantallaObtenerParquesRoom(
                        appUIState = uiStateParquesRoom,
                        onParquesRoomObtenidos = {viewModelParquesRoom.obtenerParquesRoom()},
                        onParquesRoomPulsado = {
                            viewModelParquesRoom.obtenerParqueRoom(it)
                            navController.navigate(
                                Pantallas.ActualizarParqueRoom.name,

                            )

                        },
                        modifier = Modifier.fillMaxSize()

                    )
                }

                composable(route = Pantallas.ActualizarParqueRoom.name) {
                    PantallaActualizarParqueRoomPulsado(

                        parquesRoom = viewModelParquesRoom.parquesRoomPulsado,

                        onParquesRoomActualizado = {
                            viewModelParquesRoom.actualizarParqueRoom(it)
                            navController.popBackStack(
                                Pantallas.ObtenerParquesRoom.name,
                            inclusive = false
                            )
                        },

                        modifier = Modifier.fillMaxSize()

                    )
                }







            }
        }
    }
}



@Composable
private fun DrawerContent(
    menu: Array<DrawerMenu>,
    pantallaActual: Pantallas,
    onMenuClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(150.dp),
                imageVector = Icons.Filled.AccountCircle,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        menu.forEach {
            NavigationDrawerItem(
                label = { Text(text = stringResource(id = it.titulo)) },
                icon = { Icon(imageVector = it.icono, contentDescription = null) },
                selected = it.titulo == pantallaActual.titulo,
                onClick = {
                    onMenuClick(it.ruta)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    pantallaActual: Pantallas,
    puedeNavegarAtras: Boolean,
    onNavegarAtras: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(text = stringResource(id = pantallaActual.titulo)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if(puedeNavegarAtras) {
                IconButton(onClick = onNavegarAtras) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription ="Atras"
                    )
                }
            }
        },
        modifier = modifier
    )
}