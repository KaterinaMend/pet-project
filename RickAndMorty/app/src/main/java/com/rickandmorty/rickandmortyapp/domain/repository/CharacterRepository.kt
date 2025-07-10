
package com.rickandmorty.rickandmortyapp.domain.repository

import com.rickandmorty.rickandmortyapp.domain.models.CharacterItem

interface CharacterRepository {
    suspend fun getByName(name: String): List<CharacterItem>
    suspend fun getById(id: String): CharacterItem
}
