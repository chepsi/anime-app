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
    controller: NavHostController
) {
    NavHost(controller, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) {
            HomeScreen()
        }

        composable(Screens.Favorites.route) {
            FavoritesScreen()
        }

        composable(Screens.Settings.route) {
            SettingsScreen()
        }
    }
}
