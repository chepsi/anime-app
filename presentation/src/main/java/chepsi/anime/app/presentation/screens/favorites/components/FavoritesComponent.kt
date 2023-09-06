package chepsi.anime.app.presentation.screens.favorites.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import chepsi.anime.app.presentation.screens.home.model.AnimePresentationModel
import chepsi.anime.app.presentation.theme.AnimeAppTheme

@Composable
fun FavoritesComponent(favorites: List<AnimePresentationModel>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(favorites) { favorite ->
            FavoriteComponent(favorite = favorite)
        }
    }
}

@Preview
@Composable
private fun FavoritesComponentPreview() {
    val favorite = AnimePresentationModel(
        name = "Fullmetal Alchemist: Brotherhood",
        imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
        score = 9.1,
        isFavorite = true,
        id = 0
    )
    val items = (0..10).map { favorite }
    AnimeAppTheme {
        FavoritesComponent(favorites = items)
    }
}
