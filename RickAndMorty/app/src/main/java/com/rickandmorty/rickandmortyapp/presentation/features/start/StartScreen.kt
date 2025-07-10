package com.rickandmorty.rickandmortyapp.presentation.features.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rickandmorty.rickandmortyapp.R
import com.rickandmorty.rickandmortyapp.core.design.SystemBarsColorDisposableEffect
import com.rickandmorty.rickandmortyapp.core.design.theme.itemWidth216
import com.rickandmorty.rickandmortyapp.core.design.theme.padding16
import com.rickandmorty.rickandmortyapp.core.design.theme.space16
import com.rickandmorty.rickandmortyapp.core.design.theme.space32
import com.rickandmorty.rickandmortyapp.core.design.theme.space40
import com.rickandmorty.rickandmortyapp.core.widgets.BottomBarInsetsSpacer
import com.rickandmorty.rickandmortyapp.core.widgets.DefaultButton
import com.rickandmorty.rickandmortyapp.core.widgets.EnterImage
import com.rickandmorty.rickandmortyapp.core.design.theme.RickAndMortyAppTheme
import com.rickandmorty.rickandmortyapp.core.widgets.LogoTitle
import com.rickandmorty.rickandmortyapp.core.widgets.StatusBarInsetsSpacer

@Composable
fun StartScreen(modifier: Modifier = Modifier, onGetStarted: () -> Unit) {
    SystemBarsColorDisposableEffect(false)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(padding16)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StatusBarInsetsSpacer()
        Spacer(modifier = Modifier.height(space16))
        LogoTitle()
        Spacer(modifier = Modifier.height(space32))
        EnterImage(imageResId = R.drawable.rickandmorty)
        Spacer(modifier = Modifier.height(space32))
        Spacer(modifier = modifier.height(space40))
        DefaultButton(
            modifier = Modifier.width(itemWidth216),
            textResId = R.string.get_started,
            onClick = onGetStarted)
        BottomBarInsetsSpacer()
    }
}


@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    RickAndMortyAppTheme {
        StartScreen(onGetStarted = {})
    }
}