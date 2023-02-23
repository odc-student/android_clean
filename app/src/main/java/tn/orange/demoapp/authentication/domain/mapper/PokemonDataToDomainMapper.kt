package tn.orange.demoapp.authentication.domain.mapper

import tn.orange.demoapp.authentication.data.model.PokemonApiModelItem
import tn.orange.demoapp.authentication.domain.model.PokemonDomainModel
import tn.orange.demoapp.common.mediaUrl

class PokemonDataToDomainMapper {

    fun toDomain(input: PokemonApiModelItem): PokemonDomainModel = PokemonDomainModel(
        name = input.name,
        imageUrl = "$mediaUrl/${input.variations.firstOrNull()?.image.orEmpty()}",
        variation = input.variations.map {
            it.description
        }
    )
}

fun PokemonApiModelItem.toDomain() = PokemonDomainModel(
    name = this.name,
    imageUrl = "$mediaUrl/${this.variations.firstOrNull()?.image.orEmpty()}",
    variation = this.variations.map {
        it.description
    }
)