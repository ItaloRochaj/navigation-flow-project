package br.com.treinamento.navegacaofluxotelas.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
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
fun HomeScreen(onDestinationClick: (Int) -> Unit) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFF8F9FA))
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Header()
            Spacer(modifier = Modifier.height(24.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(24.dp))
            Categories()
            Spacer(modifier = Modifier.height(24.dp))
            PopularSection(onDestinationClick)
            Spacer(modifier = Modifier.height(24.dp))
            RecommendedSection(onDestinationClick)
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Explore", color = Color.Gray, fontSize = 14.sp)
            Text(text = "Recife", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color(0xFF1A73E8))
            Text(text = "Recife, BRA", color = Color.Gray, fontSize = 14.sp)
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = null, tint = Color.Gray)
        }
    }
}

@Composable
fun SearchBar() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFF1F3F4)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Encontre", color = Color.Gray)
        }
    }
}

@Composable
fun Categories() {
    val categories = listOf("Localização", "Passeios", "Comida", "Arte")
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items(categories) { category ->
            val isSelected = category == "Localização"
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = if (isSelected) Color(0xFFE8F0FE) else Color.Transparent,
                border = if (!isSelected) null else null // Border not visible in screenshot
            ) {
                Text(
                    text = category,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    color = if (isSelected) Color(0xFF1A73E8) else Color.Gray,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun PopularSection(onDestinationClick: (Int) -> Unit) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(text = "Popular", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Ver tudo", color = Color(0xFF1A73E8), fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            PopularCard(destinations[3], Modifier.weight(1f), onDestinationClick)
            PopularCard(destinations[4], Modifier.weight(1f), onDestinationClick)
        }
    }
}

@Composable
fun PopularCard(destination: Destination, modifier: Modifier, onClick: (Int) -> Unit) {
    Card(
        modifier = modifier
            .height(240.dp)
            .clickable { onClick(destination.id) },
        shape = RoundedCornerShape(24.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = destination.imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Surface(
                        color = Color.Black.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = destination.name,
                            color = Color.White,
                            fontSize = 10.sp,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                    Surface(
                        color = Color.White,
                        shape = CircleShape,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = null,
                            tint = Color.Red,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
                
                Surface(
                    color = Color.Black.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFB400), modifier = Modifier.size(12.dp))
                        Text(text = "4.1", color = Color.White, fontSize = 10.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun RecommendedSection(onDestinationClick: (Int) -> Unit) {
    Column {
        Text(text = "Recomendado", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            RecommendedCard(destinations[1], Modifier.weight(1f), "4N/5D", onDestinationClick)
            RecommendedCard(destinations[2], Modifier.weight(1f), "2N/3D", onDestinationClick)
        }
    }
}

@Composable
fun RecommendedCard(destination: Destination, modifier: Modifier, duration: String, onClick: (Int) -> Unit) {
    Column(modifier = modifier.clickable { onClick(destination.id) }) {
        Card(
            modifier = Modifier.height(120.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box {
                Image(
                    painter = painterResource(id = destination.imageRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Surface(
                    modifier = Modifier.align(Alignment.BottomEnd).padding(8.dp),
                    color = Color.Black.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = duration, color = Color.White, fontSize = 10.sp, modifier = Modifier.padding(horizontal = 4.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = destination.name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.AutoMirrored.Filled.TrendingUp, contentDescription = null, tint = Color(0xFF1A73E8), modifier = Modifier.size(12.dp))
            Text(text = " Em Alta", color = Color.Gray, fontSize = 10.sp)
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier.height(64.dp)
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            selected = true,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF1A73E8),
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ConfirmationNumber, contentDescription = null) },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.FavoriteBorder, contentDescription = null) },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.PersonOutline, contentDescription = null) },
            selected = false,
            onClick = {}
        )
    }
}
