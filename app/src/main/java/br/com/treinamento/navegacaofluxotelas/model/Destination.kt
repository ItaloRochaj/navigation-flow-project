package br.com.treinamento.navegacaofluxotelas.model

import androidx.annotation.DrawableRes

data class Destination(
    val id: Int,
    val name: String,
    val description: String,
    val location: String = "Recife, BRA",
    val rating: Double = 4.5,
    val reviewsCount: Int = 355,
    val price: String,
    @DrawableRes val imageRes: Int,
    val facilities: List<Facility> = listOf(
        Facility("1 Heater", "Heater"),
        Facility("Dinner", "Dinner"),
        Facility("1 Tub", "Tub"),
        Facility("Pool", "Pool")
    )
)

data class Facility(
    val name: String,
    val icon: String // Just a string for now, will map to icons
)
