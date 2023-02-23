package tn.orange.demoapp.authentication.data

import retrofit2.http.GET
import tn.orange.demoapp.authentication.data.model.PokemonApiModel

interface ApiService {

    @GET("robert-z/simple-pokemon-json-api/master/data/pokemon.json")
    suspend fun getPokemons(): PokemonApiModel
}