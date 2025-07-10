package com.rickandmorty.rickandmortyapp.presentation.features.bottom_menu


import CharacterGraph
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rickandmorty.rickandmortyapp.app.di.DiProvider
import com.rickandmorty.rickandmortyapp.core.design.SystemBarsColorDisposableEffect
import com.rickandmorty.rickandmortyapp.core.navigation.TopDestinationsCollection
import com.rickandmorty.rickandmortyapp.presentation.features.bottom_character.navigation.BottomCharacterNavigator
import com.rickandmorty.rickandmortyapp.presentation.features.bottom_character.navigation.characterNavigator
import character
import com.rickandmorty.rickandmortyapp.core.design.theme.RickAndMortyAppTheme

@Composable
fun BottomCharacterScreen(externalNavigator: BottomCharacterNavigator) {
    val navController: NavHostController = rememberNavController()

    val bottomCharacterViewModel: BottomCharacterViewModel = viewModel(
        factory = BottomCharacterViewModel.Factory(
            topLevelDestinationsCollection = DiProvider.di.get(TopDestinationsCollection::class)
        )
    )
    val bottomCharacterUiState by bottomCharacterViewModel.uiState.collectAsStateWithLifecycle()

            NavHost(
                navController = navController,
                startDestination = CharacterGraph
            ) {
                character(navController.characterNavigator(externalNavigator))
            }

            SystemBarsColorDisposableEffect(true)
}
@Preview
@Composable
fun BottomCharacterScreenPreview() {
    RickAndMortyAppTheme {
        BottomCharacterScreen(
            externalNavigator = object: BottomCharacterNavigator {
                override fun onNavigateToDetails(characterItemId: String) {
                    TODO("Not yet implemented")
                }

                override fun onLogout() {
                    TODO("Not yet implemented")
                }

                override fun onNavigateUp() {
                    TODO("Not yet implemented")
                }
            }

        )
    }
}