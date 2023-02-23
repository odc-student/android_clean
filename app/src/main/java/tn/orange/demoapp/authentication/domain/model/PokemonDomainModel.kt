package tn.orange.demoapp.authentication.domain.model

data class PokemonDomainModel(
    val name: String,
    val imageUrl: String,
    val variation: List<String>
)
