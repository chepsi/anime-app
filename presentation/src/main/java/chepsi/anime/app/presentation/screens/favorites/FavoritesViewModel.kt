package chepsi.anime.app.presentation.screens.favorites

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import chepsi.anime.app.domain.favorite.repository.FavoriteRepository
import chepsi.anime.app.presentation.screens.favorites.model.FavoritesScreenState
import chepsi.anime.app.presentation.screens.home.mapper.toPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {
    var favoritesScreenState by mutableStateOf(FavoritesScreenState())
    fun onFetchFavorites() {
        viewModelScope.launch {
            favoriteRepository.fetchFavorites().collect { favorites ->
                favoritesScreenState = favoritesScreenState.copy(
                    anime = favorites.toPresentation(),
                    isEmpty = favorites.isEmpty()
                )
            }
        }
    }
}
