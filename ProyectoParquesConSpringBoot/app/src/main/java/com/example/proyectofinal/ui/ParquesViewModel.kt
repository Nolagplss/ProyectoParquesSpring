package com.example.proyectofinal.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.proyectofinal.ParquesAplicacion
import com.example.proyectofinal.datos.ParquesRepositorio
import com.example.proyectofinal.modelo.Parques
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface ParquesUIState{

    data class ObtenerParqueExito(val parques: List<Parques>) :ParquesUIState
    data class CrearParqueExito(val parques: Parques) : ParquesUIState
    data class ActualizarParqueExito(val parques: Parques) : ParquesUIState
    data class EliminarParqueExito(val id: Int) : ParquesUIState

    object ErrorParque : ParquesUIState
    object CargandoParque : ParquesUIState
}

class ParquesViewModel(private val parquesRepositorio: ParquesRepositorio
) : ViewModel() {


    var parqueUIState: ParquesUIState by mutableStateOf(ParquesUIState.CargandoParque)
        private set

    var parquePulsado: Parques by mutableStateOf(Parques(0, "", 0.0, emptyList()))
        private set






    fun actualizarParquePulsado(parques: Parques){
        parquePulsado = parques
    }

    init{
        obtenerParques()
    }

    fun obtenerParques() {
        viewModelScope.launch {
            parqueUIState = ParquesUIState.CargandoParque
            parqueUIState = try {

                val listaParques = parquesRepositorio.obtenerParques()
                println("Parques obtenidos: $listaParques")

                ParquesUIState.ObtenerParqueExito(listaParques)

            } catch (e: IOException){
                println("Error de red: ${e.message}")
                ParquesUIState.ErrorParque
            } catch (e: HttpException){
                println("Error de http: ${e.message}")
                ParquesUIState.ErrorParque
            }
        }
    }

    fun insertarParque(parques: Parques) {
        viewModelScope.launch {
            parqueUIState  = ParquesUIState.CargandoParque
            parqueUIState  = try {
                // Verificamos si la lista de especies no es nula y luego mostramos sus nombres
                val especiesNombres = parques.listaEspecies?.joinToString(", ") { it.nombre } ?: "Sin especies"

                println("Parque dentro del insertarViewModel: ${especiesNombres}")
                val parqueInsertado = parquesRepositorio.insertarParque(parques)
                println("Parque insertado: ${parqueInsertado.listaEspecies}")



                ParquesUIState.CrearParqueExito(parqueInsertado)
            } catch (e: IOException) {
                ParquesUIState.ErrorParque
            } catch (e: HttpException) {
                ParquesUIState.ErrorParque
            }
        }
    }

    fun actualizarParque(id: Int, parques: Parques) {
        viewModelScope.launch {
            parqueUIState = ParquesUIState.CargandoParque
            parqueUIState = try {
                val parqueActualizado = parquesRepositorio.actualizarParque(id, parques)
                obtenerParques()
                ParquesUIState.ActualizarParqueExito(parqueActualizado)
            } catch (e: IOException) {
                ParquesUIState.ErrorParque
            } catch (e: HttpException) {
                ParquesUIState.ErrorParque
            }
        }
    }


    fun eliminarParque(id: Int) {
        viewModelScope.launch {
            parqueUIState = ParquesUIState.CargandoParque
            parqueUIState = try {
                parquesRepositorio.eliminarParque(id)
                ParquesUIState.EliminarParqueExito(id)
            } catch (e: IOException) {
                ParquesUIState.ErrorParque
            } catch (e: HttpException) {
                ParquesUIState.ErrorParque
            }
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as ParquesAplicacion)
                val contenedorApp = application.contenedorParques
                ParquesViewModel(parquesRepositorio = contenedorApp.parquesRepositorio)
            }
        }
    }





}