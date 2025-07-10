package com.rickandmorty.rickandmortyapp.presentation.features.start.navigation

import android.annotation.SuppressLint
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rickandmorty.rickandmortyapp.presentation.features.start.StartScreen
import kotlinx.serialization.Serializable

@Serializable
data object StartDestination

interface StartNavigator {
    fun onNavigateAfterStarted()
}

@SuppressLint("RestrictedApi")
fun NavGraphBuilder.start(externalNavigator: StartNavigator) {
    composable<StartDestination> {
        StartScreen(onGetStarted = externalNavigator::onNavigateAfterStarted)
    }
}
