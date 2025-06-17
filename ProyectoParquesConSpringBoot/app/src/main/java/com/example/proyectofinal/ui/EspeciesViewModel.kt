package com.example.proyectofinal.ui

import com.example.proyectofinal.datos.ConexionEspecieRepositorio
import com.example.proyectofinal.datos.EspeciesRepositorio
import com.example.proyectofinal.modelo.Especies


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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface EspeciesUIState{

    data class ObtenerEspecieExito(val especies: List<Especies>) :EspeciesUIState
    data class CrearEspecieExito(val especies: Especies) : EspeciesUIState
    data class BuscarEspecieExito(val especie: Especies) : EspeciesUIState
    data class EliminarEspecieExito(val id: Int): EspeciesUIState
    data class ActualizarEspecieExito(val especies: Especies): EspeciesUIState


    object ErrorEspecie : EspeciesUIState
    object ErrorBuscarEspecie : EspeciesUIState
    object CargarEspecie : EspeciesUIState

}

class EspeciesViewModel(private val especiesRepositorio: EspeciesRepositorio
) : ViewModel() {


    var especieUIState: EspeciesUIState by mutableStateOf(EspeciesUIState.CargarEspecie)
        private set

    var especiePulsada: Especies by mutableStateOf(Especies(0,"","",""))
        private set

    var especieBuscada by mutableStateOf<Especies?>(null)
        private set


    fun actualizarEspeciePulsada(especies: Especies){
        especiePulsada = especies
    }

    init{
        obtenerEspecies()
    }

    fun obtenerEspecies() {
        viewModelScope.launch {
            especieUIState = EspeciesUIState.CargarEspecie
            especieUIState = try {
                val listaEspecies = especiesRepositorio.obtenerEspecies()
                EspeciesUIState.ObtenerEspecieExito(listaEspecies)

            } catch (e: IOException){
                println("Error de red: ${e.message}")
                EspeciesUIState.ErrorEspecie
            } catch (e: HttpException){
                println("Error de http: ${e.message}")
                EspeciesUIState.ErrorEspecie
            }
        }
    }

    fun insertarEspecie(especies: Especies) {
        viewModelScope.launch {
            especieUIState  = EspeciesUIState.CargarEspecie
            especieUIState  = try {
                val especieInsertada = especiesRepositorio.insertarEspecie(especies)
                EspeciesUIState.CrearEspecieExito(especieInsertada)
            } catch (e: IOException) {
                EspeciesUIState.ErrorEspecie
            } catch (e: HttpException) {
                EspeciesUIState.ErrorEspecie
            }
        }
    }
    fun actualizarEspecie(id: Int, especies: Especies) {
        viewModelScope.launch {
            especieUIState = EspeciesUIState.CargarEspecie
            especieUIState = try {
                val especieActualizada = especiesRepositorio.actualizarEspecie(id, especies)
                EspeciesUIState.ActualizarEspecieExito(especieActualizada)
            } catch (e: IOException) {
                EspeciesUIState.ErrorEspecie
            } catch (e: HttpException) {
                EspeciesUIState.ErrorEspecie
            }
        }
    }

    fun eliminarEspecie(id: Int) {
        viewModelScope.launch {
            especieUIState = EspeciesUIState.CargarEspecie
            especieUIState = try {
                especiesRepositorio.eliminarEspecie(id)
                EspeciesUIState.EliminarEspecieExito(id)
            } catch (e: IOException) {
                EspeciesUIState.ErrorEspecie
            } catch (e: HttpException) {
                EspeciesUIState.ErrorEspecie
            }
        }
    }


    //Buscar especie por nombre
    fun buscarEspeciePorNombre(id: Int) {
        viewModelScope.launch {
            try {
                val especie = especiesRepositorio.buscarEspeciePorId(id)
                print("Debajo del especiesRepositorio.buscarEspeciePOrID")
                if (especie != null) {
                    especieBuscada = especie // Almacena la especie encontrada
                    println("Especie encontrada: ${especie.nombre}") // Verificar si se ha encontrado
                } else {
                    especieBuscada = null
                    println("No se encontró la especie")
                }
            } catch (e: Exception) {
                especieBuscada = null
                println("Error al buscar la especie: ${e.message}")
            }
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as ParquesAplicacion)
                val contenedorApp = application.contenedorParques
                EspeciesViewModel(especiesRepositorio = contenedorApp.especiesRepositorio)
            }
        }
    }





}