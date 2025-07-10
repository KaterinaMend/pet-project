package com.rickandmorty.rickandmortyapp.presentation.features.main.navigation

import androidx.navigation.NavHostController
import com.rickandmorty.rickandmortyapp.core.navigation.navigateSafeSingleTopTo
import com.rickandmorty.rickandmortyapp.presentation.features.bottom_character.navigation.BottomCharacterNavigator
import com.rickandmorty.rickandmortyapp.presentation.features.bottom_character.navigation.BottomCharacterRoute
import com.rickandmorty.rickandmortyapp.presentation.features.details.navigation.navigateToDetails
import com.rickandmorty.rickandmortyapp.presentation.features.start.navigation.StartNavigator

fun NavHostController.startNavigator(): StartNavigator =
    object : StartNavigator {
        override fun onNavigateAfterStarted() {
            popBackStack()
            navigateSafeSingleTopTo(BottomCharacterRoute)
        }
    }



fun NavHostController.bottomNavigator(): BottomCharacterNavigator =
    object : BottomCharacterNavigator {
        override fun onNavigateToDetails(characterItemId: String) {
            navigateToDetails(characterItemId = characterItemId)
        }

        override fun onLogout() {
            popBackStack()
        }

        override fun onNavigateUp() {
            popBackStack()
        }
    }