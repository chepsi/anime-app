package chepsi.anime.app.presentation.components.navigation

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import chepsi.anime.app.presentation.theme.AnimeAppTheme

@Composable
fun BottomNavigationComponent(controller: NavHostController) {
    BottomAppBar {
        val navBackStackEntry by controller.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        bottomNavigationScreens.forEach { screen ->
            val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            NavigationBarItem(
                selected = selected,
                icon = { Icon(screen.icon, screen.title) },
                label = { Text(screen.title, style = MaterialTheme.typography.titleSmall) },
                alwaysShowLabel = true,
                onClick = {
                    controller.navigate(screen.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(Screens.Home.route)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                    selectedTextColor = MaterialTheme.colorScheme.secondary,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground,
                    indicatorColor = MaterialTheme.colorScheme.background.copy(alpha = 0f)
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationComponentPreview() {
    AnimeAppTheme {
        BottomNavigationComponent(rememberNavController())
    }
}
