package br.com.treinamento.navegacaofluxotelas.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.treinamento.navegacaofluxotelas.model.Destination
import br.com.treinamento.navegacaofluxotelas.model.destinations

@Composable
fun DetailScreen(destinationId: Int, onBackClick: () -> Unit) {
    val destination = destinations.find { it.id == destinationId } ?: destinations[0]

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(24.dp))
            ) {
                Image(
                    painter = painterResource(id = destination.imageRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                
                // Botão de Voltar
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .padding(16.dp)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .size(40.dp)
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(20.dp))
                }
                
                Surface(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                        .offset(y = 24.dp),
                    shape = CircleShape,
                    color = Color.White,
                    shadowElevation = 4.dp
                ) {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }

            Column(modifier = Modifier.padding(24.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = destination.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Show map", color = Color(0xFF1A73E8), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFB400), modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "${destination.rating} (${destination.reviewsCount} Reviews)", color = Color.Gray, fontSize = 14.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = destination.description,
                    color = Color.Gray,
                    fontSize = 15.sp,
                    lineHeight = 22.sp
                )
                
                Text(
                    text = "Leia mais",
                    color = Color(0xFF1A73E8),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))
                
                Text(text = "Facilidades", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    FacilityItem("1 Heater", Icons.Default.Wifi)
                    
                    when (destination.name) {
                        "Cais do Sertão" -> {
                            FacilityItem("Dinner", Icons.Default.Restaurant)
                            FacilityItem("fones", Icons.Default.Headphones)
                            FacilityItem("exposição", Icons.Default.Museum)
                        }
                        "Esculturas" -> {
                            FacilityItem("barco", Icons.Default.DirectionsBoat)
                            FacilityItem("passeio", Icons.Default.Hiking)
                            FacilityItem("mar", Icons.Default.Waves)
                        }
                        "Paço do Frevo" -> {
                            FacilityItem("Dinner", Icons.Default.Restaurant)
                            FacilityItem("cafeteria", Icons.Default.Coffee)
                            FacilityItem("museu", Icons.Default.Museum)
                        }
                        "Cinema São Luiz" -> {
                            FacilityItem("Dinner", Icons.Default.Restaurant)
                            FacilityItem("bilheteria", Icons.Default.ConfirmationNumber)
                            FacilityItem("filmes", Icons.Default.Movie)
                        }
                        else -> {
                            FacilityItem("Dinner", Icons.Default.Restaurant)
                            FacilityItem("1 Tub", Icons.Default.Bathtub)
                            FacilityItem("Pool", Icons.Default.Pool)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(text = "Preço", color = Color.Gray, fontSize = 14.sp)
                        Text(text = destination.price, color = Color(0xFF00C896), fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    }
                    
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .height(56.dp)
                            .width(200.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A73E8))
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Reservar agora", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FacilityItem(name: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFF1F3F4),
        modifier = Modifier.size(72.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(icon, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = name, fontSize = 10.sp, color = Color.Gray)
        }
    }
}
