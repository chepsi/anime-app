package chepsi.anime.app.presentation.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String, val icon: ImageVector, val title: String) {
    data object Home : Screens("/home", Icons.Default.Home, "Home")
    data object Search : Screens("/search", Icons.Default.Search, "Search")
    data object Favorites : Screens("/favorites", Icons.Default.Favorite, "Favorites")
}

val bottomNavigationScreens = listOf(Screens.Home, Screens.Search, Screens.Favorites)
