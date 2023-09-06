package chepsi.anime.app.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import chepsi.anime.app.presentation.screens.home.components.HomeAnimeListComponent
import chepsi.anime.app.presentation.theme.AnimeAppTheme

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        homeViewModel.onFetchAnimeAction()
    }
    val screenState = homeViewModel.homeScreenState
    val isRefreshing = screenState.isLoading
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = { homeViewModel.onRefreshAction() }
    )
    Box(
        Modifier.pullRefresh(pullRefreshState)
    ) {
        HomeAnimeListComponent(
            animes = screenState.anime,
            onUpdateFavoriteItem = { request ->
                homeViewModel.onUpdateFavorite(request)
            }
        )

        PullRefreshIndicator(
            isRefreshing,
            pullRefreshState,
            Modifier
                .align(Alignment.TopCenter)
                .padding(20.dp)
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    AnimeAppTheme { HomeScreen() }
}
