package com.rickandmorty.rickandmortyapp.app.di


import com.rickandmorty.rickandmortyapp.domain.usecases.character.GetCharacterItemsUseCase
import com.rickandmorty.rickandmortyapp.domain.usecases.character.GetSingleCharacterItemUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetCharacterItemsUseCase> {
        GetCharacterItemsUseCase(
            repository = get()
        )
    }

    factory<GetSingleCharacterItemUseCase> {
        GetSingleCharacterItemUseCase(
            repository = get()
        )
    }
}