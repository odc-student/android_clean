package tn.orange.demoapp.authentication.domain.usecase

import tn.orange.demoapp.authentication.domain.PokemonRepository
import tn.orange.demoapp.authentication.presentation.model.toPresentation

class FetchPokemonUseCase(
    private val repository: PokemonRepository
) {

    suspend fun fetchPokemons() = repository.fetchPokemons().map { it.toPresentation() }
}