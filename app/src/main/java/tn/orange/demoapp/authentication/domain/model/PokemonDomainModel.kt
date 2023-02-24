package tn.orange.demoapp.authentication.domain.model

import tn.orange.demoapp.authentication.data.model.PokemonApiModelItem
import tn.orange.demoapp.common.mediaUrl

data class PokemonDomainModel(
    val name: String,
    val imageUrl: String,
    val variation: List<String>,
    val types: List<String>,
    val health: Int,
    val defense: Int,
    val link: String

)

fun PokemonApiModelItem.toDomain() = PokemonDomainModel(
    name = this.name,
    imageUrl = "$mediaUrl/${this.variations.firstOrNull()?.image.orEmpty()}",
    variation = this.variations.map {
        it.description
    },
    health = this.variations.first().stats.hp,
    defense = this.variations.first().stats.defense,
    types = this.variations.first().types,
    link = this.link
)
