package com.rickandmorty.rickandmortyapp.app

import CharacterTopLevelDestination
import android.app.Application
import com.rickandmorty.rickandmortyapp.BuildConfig
import com.rickandmorty.rickandmortyapp.app.di.DiProvider
import com.rickandmorty.rickandmortyapp.app.di.GlobalDi
import com.rickandmorty.rickandmortyapp.app.di.GlobalDiImpl
import com.rickandmorty.rickandmortyapp.core.navigation.TopDestinationsCollection
import com.rickandmorty.rickandmortyapp.data.network.api.RickAndMortyApiNetwork
import com.rickandmorty.rickandmortyapp.data.repository.CharacterRepositoryImpl
import com.rickandmorty.rickandmortyapp.data.storage.api.CharacterStorage
import com.rickandmorty.rickandmortyapp.data.storage.memory.CharacterMemoryStorage
import com.rickandmorty.rickandmortyapp.domain.repository.CharacterRepository
import com.rickandmorty.rickandmortyapp.domain.usecases.character.GetCharacterItemsUseCase
import com.rickandmorty.rickandmortyapp.domain.usecases.character.GetSingleCharacterItemUseCase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.collections.immutable.persistentListOf

class RickAndMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DiProvider.di = initDi()
    }

    private fun initDi(): GlobalDi {
        val di = GlobalDiImpl()

        // network api
        val api = provideRickAndMortyApi(
            BuildConfig.API_URL,
            provideMoshi()
        )
        di.add(RickAndMortyApiNetwork::class, api)

        // storage
        di.add(CharacterStorage::class, CharacterMemoryStorage())

        // repositories
        di.add(
            CharacterRepository::class, CharacterRepositoryImpl(
                characterStorage = di.get(CharacterStorage::class),
                rickandmortyApi = di.get(RickAndMortyApiNetwork::class)
            )
        )

        // use cases
        di.add(
            GetCharacterItemsUseCase::class, GetCharacterItemsUseCase(
                repository = di.get(CharacterRepository::class)
            )
        )

        di.add(
            GetSingleCharacterItemUseCase::class,
            GetSingleCharacterItemUseCase(repository = di.get(CharacterRepository::class))
        )

        // navigation
        di.add(
            TopDestinationsCollection::class, TopDestinationsCollection(
                items = persistentListOf(
                    CharacterTopLevelDestination(),
                )
            )
        )

        return di
    }
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
