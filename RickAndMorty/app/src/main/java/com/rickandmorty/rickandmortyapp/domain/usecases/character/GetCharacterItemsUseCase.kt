
@file:Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")

package com.rickandmorty.rickandmortyapp.domain.usecases.character

import com.rickandmorty.rickandmortyapp.domain.models.CharacterItem
import com.rickandmorty.rickandmortyapp.domain.repository.CharacterRepository
import com.rickandmorty.rickandmortyapp.domain.usecases.UseCaseWithParams

class GetCharacterItemsUseCase(
    private val repository: CharacterRepository,
) : UseCaseWithParams<List<CharacterItem>, String> {
    override suspend fun invoke(name: String): List<CharacterItem> {
            return repository.getByName(name)
    }
}