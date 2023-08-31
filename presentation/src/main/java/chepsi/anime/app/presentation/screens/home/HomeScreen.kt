package chepsi.anime.app.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import chepsi.anime.app.presentation.screens.home.components.HomeAnimeListComponent
import chepsi.anime.app.presentation.theme.AnimeAppTheme

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        homeViewModel.onFetchAnimeAction()
    }
    val screenState = homeViewModel.homeScreenState

    HomeAnimeListComponent(screenState.anime)
}

@Preview
@Composable
private fun HomeScreenPreview() {
    AnimeAppTheme { HomeScreen() }
}
