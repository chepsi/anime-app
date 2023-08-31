package chepsi.anime.app.presentation.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import chepsi.anime.app.presentation.theme.AnimeAppTheme

@Composable
fun HomeScreen() {
    Text("Home")
}

@Preview
@Composable
private fun HomeScreenPreview() {
    AnimeAppTheme { HomeScreen() }
}
