package tn.orange.demoapp.authentication.presentation.model

import androidx.annotation.ColorRes
import tn.orange.demoapp.authentication.domain.model.PokemonDomainModel

data class PokemonPresentationModel(
    val name: String,
    val imageUrl: String,
    val variation: List<String>,
    @ColorRes val colorRes: Int

)

fun PokemonDomainModel.toPresentation(@ColorRes backgroundColorRes: Int) = PokemonPresentationModel(
    name = this.name,
    imageUrl = this.imageUrl,
    variation = this.variation,
    colorRes = backgroundColorRes
)
