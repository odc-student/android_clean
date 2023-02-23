package tn.orange.demoapp.authentication.domain.usecase

import tn.orange.demoapp.authentication.domain.PokemonRepository

class FetchPokemonUseCase(
    private val repository: PokemonRepository
) {

    suspend fun fetchPokemons() = repository.fetchPokemons()
}