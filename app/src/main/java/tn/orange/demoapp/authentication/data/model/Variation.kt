package tn.orange.demoapp.authentication.data.model

data class Variation(
    val abilities: List<String>,
    val description: String,
    val evolutions: List<String>,
    val height: Double,
    val image: String,
    val name: String,
    val specie: String,
    val stats: Stats,
    val types: List<String>,
    val weight: Double
)