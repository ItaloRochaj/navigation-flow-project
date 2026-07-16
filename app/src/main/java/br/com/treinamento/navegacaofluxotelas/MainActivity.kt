package br.com.treinamento.navegacaofluxotelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import br.com.treinamento.navegacaofluxotelas.navigation.NavGraph
import br.com.treinamento.navegacaofluxotelas.ui.theme.NavegacaoFluxoTelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaoFluxoTelasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFE3F2FD) // Light blue background
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
                }
            }
        }
    }
}
