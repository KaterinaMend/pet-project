package com.rickandmorty.rickandmortyapp.core.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rickandmorty.rickandmortyapp.R
import com.rickandmorty.rickandmortyapp.core.design.theme.RickAndMortyAppTheme
import com.rickandmorty.rickandmortyapp.core.design.theme.circleImageItemHeight
import com.rickandmorty.rickandmortyapp.core.design.theme.circleImageItemWidth
import com.rickandmorty.rickandmortyapp.core.design.theme.circleItemDiameter
import com.rickandmorty.rickandmortyapp.core.design.theme.cornerRadius16

@Composable
fun EnterImage(modifier: Modifier = Modifier, @DrawableRes imageResId: Int) {
    Box(
        modifier = modifier
            .width(circleItemDiameter)
            .height(circleItemDiameter)
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(size = cornerRadius16)
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .height(circleImageItemHeight)
                .width(circleImageItemWidth),
            painter = painterResource(id = imageResId),
            contentDescription = stringResource(R.string.image_description),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun EnterImagePreview() {
    RickAndMortyAppTheme {
        EnterImage(imageResId = R.drawable.rickandmorty)
    }
}