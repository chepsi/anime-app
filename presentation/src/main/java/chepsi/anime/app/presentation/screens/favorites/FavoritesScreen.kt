package chepsi.anime.app.presentation.screens.favorites

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import chepsi.anime.app.presentation.screens.favorites.components.FavoritesComponent
import chepsi.anime.app.presentation.theme.AnimeAppTheme

@Composable
fun FavoritesScreen(favoritesViewModel: FavoritesViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        favoritesViewModel.onFetchFavorites()
    }
    val screenState = favoritesViewModel.favoritesScreenState
    FavoritesComponent(screenState.anime)
}

@Preview
@Composable
private fun FavoritesScreenPreview() {
    AnimeAppTheme { FavoritesScreen() }
}
