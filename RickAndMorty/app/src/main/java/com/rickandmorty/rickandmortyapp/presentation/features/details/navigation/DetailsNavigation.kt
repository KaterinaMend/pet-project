package com.rickandmorty.rickandmortyapp.presentation.features.details.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.rickandmorty.rickandmortyapp.app.di.DiProvider
import com.rickandmorty.rickandmortyapp.core.navigation.RickAndMortyDestination
import com.rickandmorty.rickandmortyapp.domain.usecases.character.GetSingleCharacterItemUseCase
import com.rickandmorty.rickandmortyapp.presentation.features.details.DetailsScreen
import com.rickandmorty.rickandmortyapp.presentation.features.details.DetailsViewModel
import kotlinx.serialization.Serializable


fun NavHostController.navigateToDetails(characterItemId: String) {
    navigate(DetailsDestination(characterItemId))
}

@Serializable
data class DetailsDestination(val characterItemId: String) : RickAndMortyDestination

fun NavGraphBuilder.details(onNavigateUp: () -> Unit) {
    composable<DetailsDestination>{
        val characterItemId = it.toRoute<DetailsDestination>().characterItemId

        val viewModel: DetailsViewModel = viewModel(
            factory = DetailsViewModel.Factory(
                getSingleCharacterItemUseCase = DiProvider.di.get(GetSingleCharacterItemUseCase::class),
                characterItemId = characterItemId
            )
        )
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        DetailsScreen(
            uiState = uiState,
            onNavigateUp = onNavigateUp
        )
    }
}