package com.rickandmorty.rickandmortyapp.presentation.features.character.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rickandmorty.rickandmortyapp.core.design.theme.cornerRadius30
import com.rickandmorty.rickandmortyapp.domain.models.CharacterItem

@Composable
fun ItemCharacter(
    modifier: Modifier = Modifier,
    item: CharacterItem,
    onItemClicked: (itemId: String) -> Unit,
) {
    Card(
        modifier = modifier.fillMaxSize()
            .clickable(onClick = { onItemClicked(item.id) })
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(size = cornerRadius30)
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth()
                        .background(color = Color.Transparent),
                    model = item.image, contentDescription = item.name,
                )
                Text(
                    text = item.status,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(3.dp)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = item.name,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.secondary,
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = item.gender + "|" + item.species,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ItemCharacterPreview() {
    ItemCharacter(
        item = CharacterItem(
            id = "1",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            gender = "Male",
        ),
        onItemClicked = {}
    )
}