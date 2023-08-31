package chepsi.anime.app.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import chepsi.anime.app.presentation.screens.home.AnimePresentationModel
import chepsi.anime.app.presentation.theme.AnimeAppTheme

@Composable
fun HomeAnimeListComponent(animes: List<AnimePresentationModel>) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize().background(Color.White),
        columns = GridCells.Adaptive(minSize = 160.dp),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(animes) { anime ->
            HomeAnimeComponent(anime)
        }
    }
}

@Preview
@Composable
private fun HomeAnimeListComponentPreview() {
    val anime = (0..25).map {
        AnimePresentationModel(
            name = "Fullmetal Alchemist: Brotherhood",
            imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
            score = "9.1"
        )
    }
    AnimeAppTheme {
        HomeAnimeListComponent(anime)
    }
}
