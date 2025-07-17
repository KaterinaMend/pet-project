package com.rickandmorty.rickandmortyapp.domain.models

data class CharacterItem(
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val image: String,
    val gender: String
) {
    companion object
}

