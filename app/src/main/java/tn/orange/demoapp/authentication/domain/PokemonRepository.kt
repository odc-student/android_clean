package tn.orange.demoapp.authentication.domain

import tn.orange.demoapp.authentication.data.RemoteService
import tn.orange.demoapp.authentication.domain.mapper.toDomain

class PokemonRepository(
    private val remoteService: RemoteService
) {

    suspend fun fetchPokemons() = remoteService.getPokemons().map {
        it.toDomain()
    }
}
