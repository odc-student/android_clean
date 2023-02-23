package tn.orange.demoapp.authentication.data.model

data class PokemonApiModelItem(
    val link: String,
    val name: String,
    val num: Int,
    val variations: List<Variation>
)