package com.rickandmorty.rickandmortyapp.presentation.features.details.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.rickandmorty.rickandmortyapp.core.navigation.RickAndMortyDestination
import com.rickandmorty.rickandmortyapp.presentation.features.details.DetailsScreen
import com.rickandmorty.rickandmortyapp.presentation.features.details.DetailsViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf


fun NavHostController.navigateToDetails(characterItemId: String) {
    navigate(DetailsDestination(characterItemId))
}

@Serializable
data class DetailsDestination(val characterItemId: String) : RickAndMortyDestination

fun NavGraphBuilder.details(onNavigateUp: () -> Unit) {
    composable<DetailsDestination>{
        val characterItemId = it.toRoute<DetailsDestination>().characterItemId
        val viewModel: DetailsViewModel = koinViewModel<DetailsViewModel>(
                parameters = { parametersOf(characterItemId) }
        )
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        DetailsScreen(
            uiState = uiState,
            onNavigateUp = onNavigateUp
        )
    }
}