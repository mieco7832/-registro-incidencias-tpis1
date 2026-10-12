package sv.edu.utec.etps1.registroincidencias.ui.theme


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.math.abs
import kotlin.math.sqrt

class Acelerometro(
    val disponible: Boolean,
    val x: Float,
    val y: Float,
    val z: Float,
    val mensaje: String
)

@Composable
fun rememberAcelerometroState(): Acelerometro {
    val context = LocalContext.current
    val sensorManager = remember {
        context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }
    val acelerometro = remember {
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    var x by remember { mutableStateOf(0f) }
    var y by remember { mutableStateOf(0f) }
    var z by remember { mutableStateOf(0f) }
    var mensaje by remember {
        mutableStateOf(
            if (acelerometro == null) "Acelerómetro no disponible en este dispositivo"
            else "Iniciando sensor..."
        )
    }

    DisposableEffect(acelerometro) {
        if (acelerometro == null) {
            onDispose { }
        } else {
            val listener = object : SensorEventListener {
                override fun onSensorChanged(event: SensorEvent) {
                    x = event.values[0]
                    y = event.values[1]
                    z = event.values[2]

                    val magnitud = sqrt((x * x + y * y + z * z).toDouble()).toFloat()
                    val delta = abs(magnitud - 9.8f)
                    mensaje = when {
                        delta < 1.0f -> "Reposo"
                        delta < 3.0f -> "Movimiento leve"
                        else -> "Movimiento fuerte"
                    }
                }

                override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit
            }

            sensorManager.registerListener(
                listener,
                acelerometro,
                SensorManager.SENSOR_DELAY_NORMAL
            )

            onDispose { sensorManager.unregisterListener(listener) }
        }
    }

    return Acelerometro(
        disponible = acelerometro != null,
        x = x,
        y = y,
        z = z,
        mensaje = mensaje
    )
}

@Composable
fun AcelerometroCard(modifier: Modifier = Modifier) {
    val state = rememberAcelerometroState()

    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Sensor: Acelerómetro",
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(Modifier.height(8.dp))
            Text(text = "Estado: ${state.mensaje}")
            if (state.disponible) {
                Text(
                    text = "X: ${"%.2f".format(state.x)}  " +
                            "Y: ${"%.2f".format(state.y)}  " +
                            "Z: ${"%.2f".format(state.z)}"
                )
            }
        }
    }
}