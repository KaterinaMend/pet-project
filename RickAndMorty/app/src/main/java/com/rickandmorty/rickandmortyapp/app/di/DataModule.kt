package com.rickandmorty.rickandmortyapp.app.di

import com.rickandmorty.rickandmortyapp.BuildConfig
import com.rickandmorty.rickandmortyapp.data.network.api.RickAndMortyApi
import com.rickandmorty.rickandmortyapp.data.network.api.RickAndMortyApiNetwork
import com.rickandmorty.rickandmortyapp.data.repository.CharacterRepositoryImpl
import com.rickandmorty.rickandmortyapp.data.storage.api.CharacterStorage
import com.rickandmorty.rickandmortyapp.data.storage.memory.CharacterMemoryStorage
import com.rickandmorty.rickandmortyapp.domain.repository.CharacterRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import org.koin.dsl.module

val dataModule = module {

    single <CharacterRepository> {
        CharacterRepositoryImpl(
            characterStorage = get(),
            rickandmortyApi = get()
        )
    }

    single<CharacterStorage> {
        CharacterMemoryStorage()
    }

    single { provideMoshi() }
    single<RickAndMortyApi> { provideRickAndMortyApi(BuildConfig.API_URL, moshi = get()) }

}


private fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}

@Suppress("SameParameterValue")
private fun provideRickAndMortyApi(apiUrl: String, moshi: Moshi): RickAndMortyApiNetwork {
    return RickAndMortyApiNetwork(
        apiUrl = apiUrl,
        moshi = moshi
    )
}