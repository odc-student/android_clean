package tn.orange.demoapp.authentication.data

import tn.orange.demoapp.authentication.data.model.PokemonApiModel

interface RemoteService {
    suspend fun getPokemons(): PokemonApiModel
}

class FakeRemoteService : RemoteService {
    override suspend fun getPokemons(): PokemonApiModel = PokemonApiModel()
}

class RealRemoteService(
    private val service: ApiService
) : RemoteService {
    override suspend fun getPokemons() = service.getPokemons()
}