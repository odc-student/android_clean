package tn.orange.demoapp.authentication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import tn.orange.demoapp.R
import tn.orange.demoapp.authentication.presentation.PokemonViewModel
import tn.orange.demoapp.authentication.presentation.model.UiState.Failure
import tn.orange.demoapp.authentication.presentation.model.UiState.Loading
import tn.orange.demoapp.authentication.presentation.model.UiState.Success
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
        pokemonAdapter.onPokemonClicked = {
            findNavController().navigate(R.id.action_pokemonListFragment_to_pokemonWikiDialog)
        }
        binding.pokmeonList.apply {
            adapter = pokemonAdapter
        }
        binding.goToTop.setOnClickListener {
            binding.pokmeonList.smoothScrollToPosition(0)
        }
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is Failure -> Snackbar.make(
                    requireView(),
                    uiState.message,
                    Snackbar.LENGTH_LONG
                ).show()
                Loading -> {
                    binding.loader.visibility = View.VISIBLE
                    binding.pokmeonList.visibility = View.GONE
                }
                is Success -> {
                    binding.loader.visibility = View.GONE
                    binding.pokmeonList.visibility = View.VISIBLE
                    pokemonAdapter.submitList(uiState.pokemons)
                }
            }
        }
        viewModel.fetchPokemons()
    }
}