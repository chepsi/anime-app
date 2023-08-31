package chepsi.anime.app.presentation.screens.favorites

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import chepsi.anime.app.presentation.theme.AnimeAppTheme

@Composable
fun FavoritesScreen() {
    Text("Favorites")
}

@Preview
@Composable
private fun FavoritesScreenPreview() {
    AnimeAppTheme { FavoritesScreen() }
}
