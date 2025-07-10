package com.rickandmorty.rickandmortyapp.presentation.features.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import com.rickandmorty.rickandmortyapp.core.design.theme.RickAndMortyAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            RickAndMortyApp()
        }
    }
}

@Composable
fun RickAndMortyApp() {
    RickAndMortyAppTheme {
        RickAndMortyHost()
    }
}

