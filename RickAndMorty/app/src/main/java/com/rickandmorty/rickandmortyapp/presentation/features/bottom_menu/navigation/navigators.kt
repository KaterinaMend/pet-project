package com.rickandmorty.rickandmortyapp.presentation.features.bottom_character.navigation

import CharacterNavigator
import androidx.navigation.NavHostController


fun NavHostController.characterNavigator(externalNavigator: BottomCharacterNavigator): CharacterNavigator =
    object : CharacterNavigator {

        override fun navigateToDetails(id: String) {
            externalNavigator.onNavigateToDetails(id)
        }

        override fun onNavigateUp() {
            externalNavigator.onNavigateUp()
        }
    }

