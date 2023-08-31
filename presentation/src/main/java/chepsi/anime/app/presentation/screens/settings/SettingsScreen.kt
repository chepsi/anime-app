package chepsi.anime.app.presentation.screens.settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import chepsi.anime.app.presentation.theme.AnimeAppTheme

@Composable
fun SettingsScreen() {
    Text("Settings")
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    AnimeAppTheme { SettingsScreen() }
}
