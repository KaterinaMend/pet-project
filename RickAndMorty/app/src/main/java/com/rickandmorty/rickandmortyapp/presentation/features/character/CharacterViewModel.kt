package com.rickandmorty.rickandmortyapp.presentation.features.character

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.rickandmorty.rickandmortyapp.domain.usecases.character.GetCharacterItemsUseCase
import com.rickandmorty.rickandmortyapp.domain.models.CharacterItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


sealed interface CharacterUiState {
    data object Loading : CharacterUiState

    @Immutable
    data class Success(
        val products: ImmutableList<CharacterItem>,
        val name: String,
    ): CharacterUiState
}


class CharacterViewModel(
    private val getCharacterItemsUseCase: GetCharacterItemsUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<CharacterUiState>(CharacterUiState.Loading)
    val uiState = _uiState.asStateFlow()


    init {
        load("")
    }


    fun load(name: String){
        loadCharacter(name)
    }

    private fun loadCharacter(name: String){
        viewModelScope.launch {
            val items = getCharacterItemsUseCase(name)
            _uiState.update {_ ->
                CharacterUiState.Success(
                    products = items.toPersistentList(),
                    name = name
                )
            }
        }
    }

    fun searchQueryChange(name: String) {
        _uiState.update {
            if (it is CharacterUiState.Success) {
                it.copy(name = name)
            } else {
                it
            }
        }
        load(name)
    }


    internal class Factory(
        private val getCharacterItemsUseCase: GetCharacterItemsUseCase,
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            CharacterViewModel(
                getCharacterItemsUseCase = getCharacterItemsUseCase,
            ) as T
    }

}