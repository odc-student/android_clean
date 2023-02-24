package tn.orange.demoapp.authentication.ui.model

import androidx.annotation.ColorRes
import androidx.recyclerview.widget.DiffUtil

data class PokemonUiModel(
    val name: String,
    val imageUrl: String,
    val variation: List<String>,
    val health: Int,
    val defense: Int,
    val types: List<String>,
    val link: String,
    @ColorRes val colorRes: Int,
)

object PokemonDiffUtils : DiffUtil.ItemCallback<PokemonUiModel>() {
    override fun areItemsTheSame(oldItem: PokemonUiModel, newItem: PokemonUiModel) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: PokemonUiModel, newItem: PokemonUiModel) =
        oldItem.name == newItem.name
}
