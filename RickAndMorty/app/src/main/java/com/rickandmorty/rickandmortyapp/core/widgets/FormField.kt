package com.rickandmorty.rickandmortyapp.core.widgets

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rickandmorty.rickandmortyapp.R
import com.rickandmorty.rickandmortyapp.core.design.theme.RickAndMortyAppTheme

@Composable
fun FormField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes placeholderResId: Int,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    OutlinedTextField (
        value = value,
        shape = RoundedCornerShape(8.dp),
        modifier =
        modifier
            .height(56.dp),
        placeholder = {
            Text(
                text = stringResource(id = placeholderResId),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        visualTransformation = visualTransformation,
        onValueChange = onValueChange,
        trailingIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Поиск"
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedContainerColor = MaterialTheme.colorScheme.background
        )
    )
}


@Preview(showBackground = true)
@Composable
fun FormFieldPreview() {
    RickAndMortyAppTheme {
        FormField(
            value = "test@test.ru",
            placeholderResId = R.string.search_placeholder,
            onValueChange = {},
        )
    }
}