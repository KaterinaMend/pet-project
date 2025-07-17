package com.rickandmorty.rickandmortyapp.presentation.features.character

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.rickandmorty.rickandmortyapp.R
import com.rickandmorty.rickandmortyapp.core.widgets.LoadingIndicator
import com.rickandmorty.rickandmortyapp.core.widgets.FormField
import com.rickandmorty.rickandmortyapp.core.design.theme.RickAndMortyAppTheme
import com.rickandmorty.rickandmortyapp.core.design.theme.padding16
import com.rickandmorty.rickandmortyapp.core.design.theme.padding8
import com.rickandmorty.rickandmortyapp.core.design.theme.space16
import com.rickandmorty.rickandmortyapp.domain.models.CharacterItem
import com.rickandmorty.rickandmortyapp.presentation.features.character.widgets.ItemCharacter
import kotlinx.collections.immutable.persistentListOf


@Composable
fun CharacterScreen(
    uiState: CharacterUiState,
    onItemSelected: (itemId: String) -> Unit,
    searchQueryChange: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space16)
    ) {
        Column {
            Spacer(modifier = Modifier.height(space16))
            when (uiState) {
                is CharacterUiState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        LoadingIndicator()
                    }
                }

                is CharacterUiState.Success -> {
                    ScreenContent(
                        uiState,
                        onItemSelected = onItemSelected,
                        searchQueryChange = searchQueryChange
                    )
                }
            }
        }
    }
}

@Composable
private fun ColumnScope.ScreenContent(
    uiState: CharacterUiState.Success,
    onItemSelected: (String) -> Unit,
    searchQueryChange: (String) -> Unit,
) {
    FormField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = padding16, top = padding8, end = padding16),
        value = uiState.name,
        placeholderResId = R.string.search_placeholder,
        onValueChange = searchQueryChange
    )

    if(uiState.searchError){
        val context = LocalContext.current
            Toast.makeText(
                context, "Character not found!", Toast.LENGTH_SHORT
            ).show()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(padding8)
    ) {
        items(uiState.products) { characterItem ->
            Box(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.72f)
                    .padding(padding8)
            ) {
                ItemCharacter(
                    item = characterItem,
                    onItemClicked = onItemSelected
                )
            }
        }
    }
}


@Preview
@Composable
fun CharacterScreenPreview() {
    RickAndMortyAppTheme {
        CharacterScreen(uiState = CharacterUiState.Success(
            products = persistentListOf(
                CharacterItem(
                    id = "1",
                    name = "Rick Sanchez",
                    status = "Alive",
                    species = "Human",
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                    gender = "Male"
                ),
                CharacterItem(
                    id = "2",
                    name = "Morty Smith",
                    status = "Alive",
                    species = "Human",
                    image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                    gender = "Male"
                ),
                CharacterItem(
                    id = "3",
                    name = "Summer Smith",
                    status = "Alive",
                    species = "Human",
                    image = "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
                    gender = "Female"
                ),
                CharacterItem(
                    id = "4",
                    name = "Beth Smith",
                    status = "Alive",
                    species = "Human",
                    image = "https://rickandmortyapi.com/api/character/avatar/4.jpeg",
                    gender = "Female"
                ),
                CharacterItem(
                    id = "5",
                    name = "Jerry Smit",
                    status = "Alive",
                    species = "Human",
                    image = "https://rickandmortyapi.com/api/character/avatar/5.jpeg",
                    gender = "Male"
                )
            ),
            name = "Leticia Ward", searchError = false,
        ),
            onItemSelected = {}, searchQueryChange = {}
        )
    }
}