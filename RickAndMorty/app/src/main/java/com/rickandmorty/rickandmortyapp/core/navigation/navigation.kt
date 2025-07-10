package com.rickandmorty.rickandmortyapp.core.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import kotlinx.collections.immutable.ImmutableList

interface RickAndMortyDestination

data class TopDestinationsCollection(val items: ImmutableList<RickAndMortyTopLevelDestination>)

interface RickAndMortyTopLevelDestinationWithCount{
    val badgeValue: Int
    fun copyWithNewBadge(value: Int): RickAndMortyTopLevelDestination
}

interface RickAndMortyTopLevelDestination{
    val route: Any
    @get:DrawableRes
    val iconId: Int
    @get:StringRes
    val titleId: Int
}

fun NavHostController.navigateSafeSingleTopTo(route: Any) {
    navigate(route) {
        popUpTo(this@navigateSafeSingleTopTo.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

