package tn.orange.demoapp.authentication.presentation.model

import tn.orange.demoapp.authentication.ui.model.PokemonUiModel

// Enum

sealed class UiState {
    class Success(val pokemons: List<PokemonUiModel>) : UiState()
    object Loading : UiState()
    class Failure(val message: String) : UiState()
}