package com.rickandmorty.rickandmortyapp.data.network.api

import com.rickandmorty.rickandmortyapp.data.network.model.CharacterItemNetwork

interface RickAndMortyApi {
    fun getCharacter(): List<CharacterItemNetwork>
}
