
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rickandmorty.rickandmortyapp.R
import com.rickandmorty.rickandmortyapp.app.di.DiProvider
import com.rickandmorty.rickandmortyapp.core.navigation.RickAndMortyTopLevelDestination
import com.rickandmorty.rickandmortyapp.domain.usecases.character.GetCharacterItemsUseCase
import com.rickandmorty.rickandmortyapp.presentation.features.character.CharacterScreen
import com.rickandmorty.rickandmortyapp.presentation.features.character.CharacterViewModel
import kotlinx.serialization.Serializable

@Serializable
object CharacterGraph

data class CharacterTopLevelDestination(
    override val iconId: Int = R.drawable.ic_home,
    override val titleId: Int = R.string.character,
    override val route: CharacterGraph = CharacterGraph
) : RickAndMortyTopLevelDestination

@Serializable
data object CharacterDestination

interface CharacterNavigator{
    fun navigateToDetails(id:String)
    fun onNavigateUp()
}

fun NavGraphBuilder.character(externalNavigator: CharacterNavigator) {

    navigation<CharacterGraph>(startDestination = CharacterDestination) {
        composable<CharacterDestination> {
            val viewModel: CharacterViewModel = viewModel(
                factory = CharacterViewModel.Factory(
                    getCharacterItemsUseCase = DiProvider.di.get(GetCharacterItemsUseCase::class),
                )
            )

            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            CharacterScreen(
                uiState = uiState,
                onItemSelected = externalNavigator::navigateToDetails,
                searchQueryChange = viewModel::searchQueryChange,
            )
        }
    }

}