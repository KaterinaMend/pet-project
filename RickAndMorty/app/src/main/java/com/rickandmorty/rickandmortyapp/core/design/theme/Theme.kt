

package com.rickandmorty.rickandmortyapp.core.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val darkColorScheme = darkColorScheme(
    primary = Raven,
    secondary = EldenRingOrange,
    onSecondary = White,
    inversePrimary = CadmiumYellow,
    tertiary = GreenBellPepper,
    primaryContainer = Pink,
    error = Firebrick,
    background = White,
    surface = BrightGrey,
    onSurface = Adhesion,
    onBackground = Raven
)

private val lightColorScheme = lightColorScheme(
    primary = Raven,
    secondary = EldenRingOrange,
    onSecondary = White,
    inversePrimary = CadmiumYellow,
    tertiary = GreenBellPepper,
    primaryContainer = Pink,
    error = Firebrick,
    background = White,
    surface = BrightGrey,
    onSurface = Adhesion,
    onBackground = Raven
)

@Composable
fun RickAndMortyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme, typography = typography, content = content
    )
}