package tn.orange.demoapp.authentication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import tn.orange.demoapp.authentication.presentation.PokemonViewModel
import tn.orange.demoapp.authentication.presentation.model.UiState
import tn.orange.demoapp.authentication.ui.adapter.PokemonAdapter
import tn.orange.demoapp.databinding.PokemonListFragmentBinding

@AndroidEntryPoint
class PokemonListFragment : Fragment() {

    private val viewModel: PokemonViewModel by viewModels()
    private lateinit var binding: PokemonListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PokemonListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemonAdapter = PokemonAdapter()
        binding.pokmeonList.adapter = pokemonAdapter
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is UiState.Failure -> Snackbar.make(
                    requireView(),
                    uiState.message,
                    Snackbar.LENGTH_LONG
                ).show()
                UiState.Loading -> {
                    binding.loader.visibility = View.VISIBLE
                    binding.pokmeonList.visibility = View.GONE
                }
                is UiState.Success -> {
                    binding.loader.visibility = View.GONE
                    binding.pokmeonList.visibility = View.VISIBLE
                    pokemonAdapter.submitList(uiState.pokemons)
                }
            }
        }

        viewModel.fetchPokemons()
    }
}