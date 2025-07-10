
package com.rickandmorty.rickandmortyapp.data.repository

import com.rickandmorty.rickandmortyapp.data.exceptions.CharacterFetchException
import com.rickandmorty.rickandmortyapp.data.exceptions.CharacterItemFetchException
import com.rickandmorty.rickandmortyapp.data.mappers.toDomain
import com.rickandmorty.rickandmortyapp.data.mappers.toStorage
import com.rickandmorty.rickandmortyapp.data.network.api.RickAndMortyApi
import com.rickandmorty.rickandmortyapp.data.storage.api.CharacterStorage
import com.rickandmorty.rickandmortyapp.domain.models.CharacterItem
import com.rickandmorty.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.withContext

class CharacterRepositoryImpl(
    private val characterStorage: CharacterStorage,
    private val rickandmortyApi: RickAndMortyApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : CharacterRepository {

    override suspend fun getByName(name: String): List<CharacterItem> =
        withContext(dispatcher) {
            try {
                if (characterStorage.getByName(name).isEmpty()) {
                    val characterItems = rickandmortyApi.getCharacter().map { it.toStorage() }
                    withContext(NonCancellable){
                        characterStorage.add(characterItems)
                    }
                }
                characterStorage.getByName(name).map { it.toDomain() }
            } catch (cause: Throwable) {
                if(cause is CancellationException) throw cause
                throw CharacterFetchException(cause)
            }
        }

    override suspend fun getById(id: String): CharacterItem =
        withContext(dispatcher) {
            try {
                characterStorage.getById(id).toDomain()
            } catch (cause: Throwable) {
                if(cause is CancellationException) throw cause
                throw CharacterItemFetchException(cause)
            }
        }
}


