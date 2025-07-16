package com.rickandmorty.rickandmortyapp.app.di

import CharacterTopLevelDestination
import com.rickandmorty.rickandmortyapp.core.navigation.TopDestinationsCollection
import com.rickandmorty.rickandmortyapp.presentation.features.bottom_menu.BottomCharacterViewModel
import com.rickandmorty.rickandmortyapp.presentation.features.character.CharacterViewModel
import com.rickandmorty.rickandmortyapp.presentation.features.details.DetailsViewModel
import kotlinx.collections.immutable.persistentListOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //viewModel
    viewModel<CharacterViewModel>{
        CharacterViewModel(getCharacterItemsUseCase = get() )
    }

    viewModel<BottomCharacterViewModel>{
        BottomCharacterViewModel(topLevelDestinations = get())
    }

    viewModel { (characterItemId: String) ->
        DetailsViewModel(
            getSingleCharacterItemUseCase = get(),
            characterItemId = characterItemId // Параметр, а не DI
        )
    }

    // Навигация
    single { TopDestinationsCollection(items = persistentListOf(CharacterTopLevelDestination())) }
}