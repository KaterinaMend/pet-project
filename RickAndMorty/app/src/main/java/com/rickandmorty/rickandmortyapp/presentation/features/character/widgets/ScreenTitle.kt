package com.rickandmorty.rickandmortyapp.presentation.features.character.widgets

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rickandmorty.rickandmortyapp.R
import com.rickandmorty.rickandmortyapp.core.design.theme.RickAndMortyAppTheme

@Composable
fun ScreenTitle(modifier: Modifier = Modifier, @StringRes textResId: Int) {
    Text (modifier = modifier,
        text = stringResource(id = textResId),
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.primary)
}


@Preview
@Composable
fun ScreenTitlePreview() {
    RickAndMortyAppTheme {
        ScreenTitle(textResId = R.string.character)
    }
}