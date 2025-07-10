package com.rickandmorty.rickandmortyapp.core.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.rickandmorty.rickandmortyapp.core.design.theme.RickAndMortyAppTheme
import com.rickandmorty.rickandmortyapp.core.design.theme.defaultCapsSpanStyle
import com.rickandmorty.rickandmortyapp.core.design.theme.highlightSpanStyle

@Composable
fun LogoTitle(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Text(text = buildAnnotatedString {
            withStyle(
                style = highlightSpanStyle
            ) {
                append("R")
            }
            withStyle(
                style = defaultCapsSpanStyle
            ) {
                append("iсk")
            }
            withStyle(
                style = highlightSpanStyle
            ) {
                append("A")
            }
            withStyle(
                style = defaultCapsSpanStyle
            ) {
                append("nd")
            }
            withStyle(
                style = highlightSpanStyle
            ) {
                append("M")
            }
            withStyle(
                style = defaultCapsSpanStyle
            ) {
                append("orty")
            }
        }
        )
    }
}

@Preview(showBackground = false)
@Composable
fun LogoTitlePreview() {
    RickAndMortyAppTheme {
        LogoTitle()
    }
}