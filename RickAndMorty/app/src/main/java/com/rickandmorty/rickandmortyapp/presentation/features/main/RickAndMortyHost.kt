package com.rickandmorty.rickandmortyapp.presentation.features.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rickandmorty.rickandmortyapp.presentation.features.bottom_character.navigation.bottom_character
import com.rickandmorty.rickandmortyapp.presentation.features.main.navigation.bottomNavigator
import com.rickandmorty.rickandmortyapp.presentation.features.main.navigation.startNavigator
import com.rickandmorty.rickandmortyapp.presentation.features.start.navigation.StartDestination
import com.rickandmorty.rickandmortyapp.presentation.features.start.navigation.start

@Composable
fun RickAndMortyHost(
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = StartDestination
    ) {
        start(navController.startNavigator())
        bottom_character(navController.bottomNavigator())
    }
}
