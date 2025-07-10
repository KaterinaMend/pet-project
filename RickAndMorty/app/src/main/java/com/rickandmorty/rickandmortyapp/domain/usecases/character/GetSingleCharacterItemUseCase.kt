
@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package com.rickandmorty.rickandmortyapp.domain.usecases.character

import com.rickandmorty.rickandmortyapp.domain.models.CharacterItem
import com.rickandmorty.rickandmortyapp.domain.repository.CharacterRepository
import com.rickandmorty.rickandmortyapp.domain.usecases.UseCaseWithParams

class GetSingleCharacterItemUseCase(
    private val repository: CharacterRepository,
) : UseCaseWithParams<CharacterItem, String> {
    override suspend fun invoke(characterItemId: String): CharacterItem =
        repository.getById(id = characterItemId)
}