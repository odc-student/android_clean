package tn.orange.demoapp.authentication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import tn.orange.demoapp.common.StringDiffUtils
import tn.orange.demoapp.databinding.TypeItemViewBinding

class PokemonTypeAdapter : ListAdapter<String, PokemonTypeAdapter.PokemonTypeViewHolder>(
    StringDiffUtils
) {

    inner class PokemonTypeViewHolder(private val binding: TypeItemViewBinding) :
        ViewHolder(binding.root) {

        fun bind(type: String) {
            binding.type.text = type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonTypeViewHolder {
        val binding =
            TypeItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonTypeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonTypeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}