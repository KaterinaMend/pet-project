package com.rickandmorty.rickandmortyapp.presentation.features.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.rickandmorty.rickandmortyapp.R
import com.rickandmorty.rickandmortyapp.core.design.SystemBarsColorDisposableEffect
import com.rickandmorty.rickandmortyapp.core.design.theme.RickAndMortyAppTheme
import com.rickandmorty.rickandmortyapp.core.design.theme.defaultShadow
import com.rickandmorty.rickandmortyapp.core.design.theme.oneCornerRoundedShape
import com.rickandmorty.rickandmortyapp.core.design.theme.padding16
import com.rickandmorty.rickandmortyapp.core.design.theme.space16
import com.rickandmorty.rickandmortyapp.core.design.theme.space40
import com.rickandmorty.rickandmortyapp.core.widgets.LoadingIndicator
import com.rickandmorty.rickandmortyapp.core.widgets.StatusBarInsetsSpacer
import com.rickandmorty.rickandmortyapp.domain.models.CharacterItem

@Composable
fun DetailsScreen(uiState: DetailsUiState, onNavigateUp: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        StatusBarInsetsSpacer()
        Spacer(modifier = Modifier.height(space16))
        IconButton(
            onClick = onNavigateUp
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Navigate Back",
                tint = MaterialTheme.colorScheme.background
            )
        }

        when(uiState){
            is DetailsUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    LoadingIndicator()
                }
            }
            is DetailsUiState.Error -> {}
            is DetailsUiState.Success -> {
                Box(
                    modifier = Modifier
                        .padding(horizontal = padding16)
                        .weight(1f)
                ) {
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = uiState.characterItem.image, contentDescription = "uiState.characterItem.name"
                    )
                }
                DetailsBlock(uiState = uiState)
            }
        }

        SystemBarsColorDisposableEffect(putInDark = false)
    }

}

@Composable
private fun ColumnScope.DetailsBlock(uiState: DetailsUiState.Success){
    Box(
        modifier = Modifier
            .defaultShadow()
            .fillMaxWidth()
            .weight(1f)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = oneCornerRoundedShape
            )
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = padding16)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(space40))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = uiState.characterItem.name!!, style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = uiState.characterItem.gender,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Spacer(modifier = Modifier.height(padding16))
            Text(
                text = uiState.characterItem.species,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    RickAndMortyAppTheme {
        DetailsScreen(uiState = DetailsUiState.Success(
            characterItem = CharacterItem(
                id = "5",
                name = "Three Toppings rickandmorty",
                species = "Saba's classic thin crust, New York City rickandmorty.",
                status = "Human",
                image = "https://api.RickAndMorty.ru/rickandmorty/rickandmortya.png",
                gender = "25"
            ),
        ), onNavigateUp = {})
    }
}
