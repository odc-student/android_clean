package tn.orange.demoapp.authentication.presentation.model

import androidx.annotation.ColorRes
import tn.orange.demoapp.R
import tn.orange.demoapp.authentication.domain.model.PokemonDomainModel

data class PokemonPresentationModel(
    val name: String,
    val imageUrl: String,
    val variation: List<String>,
    val health: Int,
    val defense: Int,
    val types: List<String>,
    @ColorRes val colorRes: Int,
    val link: String,
)

fun PokemonDomainModel.toPresentation() = PokemonPresentationModel(
    name = this.name,
    imageUrl = this.imageUrl,
    variation = this.variation,
    health = this.health,
    defense = this.defense,
    types = this.types,
    colorRes = R.color.black,
    link = this.link
)
