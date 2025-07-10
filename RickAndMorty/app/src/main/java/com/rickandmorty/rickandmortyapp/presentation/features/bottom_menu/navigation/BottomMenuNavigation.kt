package com.rickandmorty.rickandmortyapp.presentation.features.bottom_character.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.rickandmorty.rickandmortyapp.presentation.features.bottom_menu.BottomCharacterScreen
import com.rickandmorty.rickandmortyapp.presentation.features.details.navigation.details
import kotlinx.serialization.Serializable


//const val BOTTOM_CHARACTER_ROUTE = "bottom_character"

@Serializable
object BottomCharacterRoute

@Serializable
private object BottomCharacterDestination

interface BottomCharacterNavigator {
    fun onNavigateToDetails(characterItemId: String)
    fun onLogout()
    fun onNavigateUp()
}


fun NavGraphBuilder.bottom_character(externalNavigator: BottomCharacterNavigator) {
    navigation<BottomCharacterRoute>(startDestination = BottomCharacterDestination){
        composable<BottomCharacterDestination> {
            BottomCharacterScreen(externalNavigator)
        }
        details(onNavigateUp = externalNavigator::onNavigateUp)
    }

}