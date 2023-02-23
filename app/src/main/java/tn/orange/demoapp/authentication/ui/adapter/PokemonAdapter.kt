package tn.orange.demoapp.authentication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import tn.orange.demoapp.authentication.ui.model.PokemonDiffUtils
import tn.orange.demoapp.authentication.ui.model.PokemonUiModel
import tn.orange.demoapp.databinding.PokemonItemViewBinding

class PokemonAdapter : ListAdapter<PokemonUiModel, PokemonAdapter.PokemonViewHolder>(
    PokemonDiffUtils
) {

    class PokemonViewHolder(private val binding: PokemonItemViewBinding) :
        ViewHolder(binding.root) {

        fun bind(pokemonUiModel: PokemonUiModel) {
            binding.pokemonName.text = pokemonUiModel.name
            binding.pokemonImage.load(pokemonUiModel.imageUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = PokemonItemViewBinding.inflate(LayoutInflater.from(parent.context))
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}