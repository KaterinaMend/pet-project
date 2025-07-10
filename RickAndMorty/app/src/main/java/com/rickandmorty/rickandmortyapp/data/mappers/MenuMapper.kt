
package com.rickandmorty.rickandmortyapp.data.mappers

import com.rickandmorty.rickandmortyapp.data.network.model.CharacterItemNetwork
import com.rickandmorty.rickandmortyapp.data.storage.model.CharacterItemEntity
import com.rickandmorty.rickandmortyapp.domain.models.CharacterItem

internal fun CharacterItemNetwork.toStorage(): CharacterItemEntity {

    return CharacterItemEntity(
        id = id,
        name = name,
        status = status,
        species = species,
        image = image,
        gender = gender
    )
}

internal fun CharacterItem.toStorage(): CharacterItemEntity {

    return CharacterItemEntity(
        id = id,
        name = name,
        status = status,
        species = species,
        image = image,
        gender = gender
    )
}

internal fun CharacterItemEntity.toDomain(): CharacterItem {
    return CharacterItem(
        id = id,
        name = name,
        status = status,
        species = species,
        image = image,
        gender = gender
    )
}