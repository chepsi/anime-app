package chepsi.anime.app.presentation.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import chepsi.anime.app.presentation.screens.favorites.FavoritesScreen
import chepsi.anime.app.presentation.screens.home.HomeScreen
import chepsi.anime.app.presentation.screens.settings.SettingsScreen

@Composable
fun NavigationComponent(
    controller: NavHostController,
    updateTitle: (String) -> Unit
) {
    NavHost(controller, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) {
            updateTitle(Screens.Home.title)
            HomeScreen()
        }

        composable(Screens.Favorites.route) {
            updateTitle(Screens.Favorites.title)
            FavoritesScreen()
        }

        composable(Screens.Settings.route) {
            updateTitle(Screens.Settings.title)
            SettingsScreen()
        }
    }
}
