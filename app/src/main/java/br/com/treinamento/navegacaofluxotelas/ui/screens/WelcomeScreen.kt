package br.com.treinamento.navegacaofluxotelas.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(onExploreClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Imagem de Fundo
        Image(
            painter = painterResource(id = br.com.treinamento.navegacaofluxotelas.R.drawable.img_novotel),
            contentDescription = "Recife Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Overlay escuro para melhorar legibilidade do texto (opcional, mas recomendado)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f)),
                        startY = 300f
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 80.dp)
            ) {
                Text(
                    text = "Explore",
                    color = Color.White,
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 70.sp
                )
                Text(
                    text = "Recife",
                    color = Color.White,
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 70.sp
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "\"Eu vi o mundo, e ele começava no Recife\"",
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 40.dp)
                )
            }

            Button(
                onClick = onExploreClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 32.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A73E8))
            ) {
                Text(text = "Explore", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
