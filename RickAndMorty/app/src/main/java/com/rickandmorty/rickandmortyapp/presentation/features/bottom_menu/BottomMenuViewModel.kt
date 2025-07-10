package com.rickandmorty.rickandmortyapp.presentation.features.bottom_menu

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.rickandmorty.rickandmortyapp.core.navigation.RickAndMortyTopLevelDestination
import com.rickandmorty.rickandmortyapp.core.navigation.TopDestinationsCollection
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@Immutable
data class BottomCharacterUiState(
    val topLevelDestinations: ImmutableList<RickAndMortyTopLevelDestination>
)

class BottomCharacterViewModel(
    private val topLevelDestinations: TopDestinationsCollection
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        BottomCharacterUiState(
            topLevelDestinations = topLevelDestinations.items.toPersistentList()
        )
    )
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            /*
            getCartUseCase().collect { itemsInCart ->
                _uiState.update { currentState ->
                    currentState.copy(
                        topLevelDestinations = currentState.topLevelDestinations
                            .map { destination ->
                                if (destination is RickAndMortyTopLevelDestinationWithCount) {
                                    destination.copyWithNewBadge(itemsInCart.size)
                                } else
                                    destination
                            }.toPersistentList()
                    )
                }
            }
             */
        }
    }


    internal class Factory(
        private val topLevelDestinationsCollection: TopDestinationsCollection,
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            BottomCharacterViewModel(
                topLevelDestinations = topLevelDestinationsCollection
            ) as T
    }
}