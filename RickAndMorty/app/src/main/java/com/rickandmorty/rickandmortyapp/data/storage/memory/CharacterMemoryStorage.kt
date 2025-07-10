package com.rickandmorty.rickandmortyapp.data.storage.memory

import com.rickandmorty.rickandmortyapp.data.storage.api.CharacterStorage
import com.rickandmorty.rickandmortyapp.data.storage.model.CharacterItemEntity

class CharacterMemoryStorage : CharacterStorage {
    private val characterItems: MutableSet<CharacterItemEntity> = mutableSetOf()

    override fun add(items: List<CharacterItemEntity>) = characterItems.addAll(items)

    override fun getAll() = characterItems.toList()

    override fun getByName(name: String) : List<CharacterItemEntity>{
        lateinit var filterCharacters: List<CharacterItemEntity>
        if (name.isNotEmpty())  filterCharacters = characterItems.filter { it.name!!.startsWith(name, ignoreCase = true) }.toList()
        else filterCharacters = characterItems.toList()
        return filterCharacters
    }

    override fun getById(id: String): CharacterItemEntity =
        characterItems.first { it.id == id }

}