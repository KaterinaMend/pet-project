package com.rickandmorty.rickandmortyapp.core.widgets

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rickandmorty.rickandmortyapp.R
import com.rickandmorty.rickandmortyapp.core.design.theme.RickAndMortyAppTheme
import com.rickandmorty.rickandmortyapp.core.design.theme.cornerRadius16
import com.rickandmorty.rickandmortyapp.core.design.theme.itemHeight40
import com.rickandmorty.rickandmortyapp.core.design.theme.zeroValue

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    @StringRes textResId: Int,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(size = cornerRadius16)
            )
            .height(itemHeight40),
        contentPadding = PaddingValues(zeroValue),
        onClick = onClick
    ) {
        Text(
            text = stringResource(id = textResId),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSecondary,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultButtonPreview() {
    RickAndMortyAppTheme {
        DefaultButton(
            modifier = Modifier.width(216.dp),
            textResId = R.string.get_started,
            onClick = {})
    }
}