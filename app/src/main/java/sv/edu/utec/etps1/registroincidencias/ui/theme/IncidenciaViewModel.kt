package sv.edu.utec.etps1.registroincidencias.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class IncidenciaViewModel: ViewModel() {
    var titulo by mutableStateOf("")
        private set

    var descripcion by mutableStateOf("")
        private set

    var prioridad by mutableStateOf("")
        private set

    fun actualizarTitulo(valor: String) {
        titulo = valor
    }

    fun actualizarDescripcion(valor: String) {
        descripcion = valor
    }

    fun seleccionarPrioridad(valor: String) {
        prioridad = valor
    }

    fun limpiarFormulario() {
        titulo = ""
        descripcion = ""
        prioridad = ""
    }
}