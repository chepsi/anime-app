package chepsi.anime.app.presentation.components.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import chepsi.anime.app.presentation.components.navigation.BottomNavigationComponent
import chepsi.anime.app.presentation.components.navigation.NavigationComponent
import chepsi.anime.app.presentation.components.toolbar.AnimeToolbar

@Composable
fun MainComponent() {
    val controller = rememberNavController()
    var title by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { AnimeToolbar(title) },
        bottomBar = { BottomNavigationComponent(controller = controller) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            NavigationComponent(controller) { currentTitle ->
                title = currentTitle
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainComponentPreview() {
    MainComponent()
}
