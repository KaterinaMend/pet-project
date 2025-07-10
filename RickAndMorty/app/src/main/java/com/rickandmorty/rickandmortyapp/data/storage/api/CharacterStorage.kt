
package com.rickandmorty.rickandmortyapp.data.storage.api

import com.rickandmorty.rickandmortyapp.data.storage.model.CharacterItemEntity

interface CharacterStorage {

    fun add(items: List<CharacterItemEntity>): Boolean

    fun getAll(): List<CharacterItemEntity>

    fun getByName(name: String): List<CharacterItemEntity>

    fun getById(id: String): CharacterItemEntity

}