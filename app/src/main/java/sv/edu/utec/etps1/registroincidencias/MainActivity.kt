package sv.edu.utec.etps1.registroincidencias

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import sv.edu.utec.etps1.registroincidencias.ui.theme.RegistroIncidenciasApp
import sv.edu.utec.etps1.registroincidencias.ui.theme.RegistroIncidenciasTheme

class MainActivity : ComponentActivity() {

    private val tag = "TPIS1_LIFECYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        setContent {
            RegistroIncidenciasTheme {
                RegistroIncidenciasApp()
            }
        }
    }

    override fun onStart() { super.onStart(); Log.d(tag, "onStart") }
    override fun onResume() { super.onResume(); Log.d(tag, "onResume") }
    override fun onPause() { Log.d(tag, "onPause"); super.onPause() }
    override fun onStop() { Log.d(tag, "onStop"); super.onStop() }
    override fun onDestroy() { Log.d(tag, "onDestroy"); super.onDestroy() }
}