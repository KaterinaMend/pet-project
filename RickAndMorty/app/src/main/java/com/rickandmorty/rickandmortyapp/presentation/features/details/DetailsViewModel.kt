package com.rickandmorty.rickandmortyapp.presentation.features.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.rickandmorty.rickandmortyapp.domain.models.CharacterItem
import com.rickandmorty.rickandmortyapp.domain.usecases.character.GetSingleCharacterItemUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface DetailsUiState {
    data object Loading : DetailsUiState
    data class Success(val characterItem: CharacterItem) : DetailsUiState
    data class Error(val message: String) : DetailsUiState
}

class DetailsViewModel(
    private val getSingleCharacterItemUseCase: GetSingleCharacterItemUseCase,
    private val characterItemId: String
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailsUiState>(
        DetailsUiState.Loading
    )
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val characterItem = getSingleCharacterItemUseCase(characterItemId)
            _uiState.update {
                DetailsUiState.Success(characterItem)
            }
        }
    }

}