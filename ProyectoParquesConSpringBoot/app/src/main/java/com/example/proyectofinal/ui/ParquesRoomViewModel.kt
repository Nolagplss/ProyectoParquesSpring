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
import com.example.proyectofinal.datos.ParquesRoomRepositorio
import com.example.proyectofinal.modelo.ParquesRoom
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface ParquesRoomUIState{
    data class ObtenerParquesRoomExitoTodos(val parquesRoom: List<ParquesRoom>) : ParquesRoomUIState
    data class ObtenerParquesRoomExito(val parquesRoom: ParquesRoom) : ParquesRoomUIState

    object CrearParquesRoomExito: ParquesRoomUIState
    object ActualizarParquesRoomExito: ParquesRoomUIState
    object ErrorParquesRoom : ParquesRoomUIState
    object CargandoParquesRoom : ParquesRoomUIState
}


class ParquesRoomViewModel(private val parquesRoomRepositorio: ParquesRoomRepositorio) : ViewModel() {

    var parquesRoomUIState: ParquesRoomUIState by mutableStateOf(ParquesRoomUIState.CargandoParquesRoom)
        private set

    var parquesRoomPulsado: ParquesRoom by mutableStateOf(ParquesRoom(0, "", 0))
        private set




    init {
        obtenerParquesRoom()
    }

    fun obtenerParquesRoom() {
        viewModelScope.launch {
            parquesRoomUIState = try {
                val lista = parquesRoomRepositorio.obtenerTodosParquesRoom()
                ParquesRoomUIState.ObtenerParquesRoomExitoTodos(lista)
            } catch (e: Exception) {
                ParquesRoomUIState.ErrorParquesRoom
            }
        }
    }

    fun obtenerParqueRoom(id: Int) {
        viewModelScope.launch {
            parquesRoomUIState = try {
                val parqueRoom = parquesRoomRepositorio.obtenerParquesRoom(id)
                parquesRoomPulsado = parqueRoom
                ParquesRoomUIState.ObtenerParquesRoomExito(parqueRoom)
            } catch (e: Exception) {
                ParquesRoomUIState.ErrorParquesRoom
            }
        }
    }

    fun insertarParqueRoom(parquesRoom: ParquesRoom) {
        viewModelScope.launch {
            parquesRoomUIState = try {
                parquesRoomRepositorio.insertarParqueRoom(parquesRoom)
                ParquesRoomUIState.CrearParquesRoomExito
            } catch (e: Exception) {
                ParquesRoomUIState.ErrorParquesRoom
            }
        }
    }

    fun actualizarParqueRoom(parquesRoom: ParquesRoom) {
        viewModelScope.launch {
            parquesRoomUIState = try {
                parquesRoomRepositorio.actualizarParqueRoom(parquesRoom)
                ParquesRoomUIState.ActualizarParquesRoomExito
            } catch (e: Exception) {
                ParquesRoomUIState.ErrorParquesRoom
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as ParquesAplicacion)
                val contenedorRoom = application.contenedorParquesRoom
                ParquesRoomViewModel(parquesRoomRepositorio = contenedorRoom.parquesRoomRepositorio)
            }
        }
    }
}