package tn.orange.demoapp.authentication.ui.model

import androidx.annotation.ColorRes
import androidx.recyclerview.widget.DiffUtil
import tn.orange.demoapp.authentication.presentation.model.PokemonPresentationModel

data class PokemonUiModel(
    val name: String,
    val imageUrl: String,
    val variation: List<String>,
    @ColorRes val colorRes: Int

)

object PokemonDiffUtils : DiffUtil.ItemCallback<PokemonUiModel>() {
    override fun areItemsTheSame(oldItem: PokemonUiModel, newItem: PokemonUiModel) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: PokemonUiModel, newItem: PokemonUiModel) =
        oldItem.name == newItem.name
}

fun PokemonPresentationModel.toUI() = PokemonUiModel(
    name = this.name,
    imageUrl = this.imageUrl,
    variation = this.variation,
    colorRes = this.colorRes
)
