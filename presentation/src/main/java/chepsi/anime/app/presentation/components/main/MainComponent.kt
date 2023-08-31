package chepsi.anime.app.presentation.components.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import chepsi.anime.app.presentation.components.navigation.BottomNavigationComponent
import chepsi.anime.app.presentation.components.navigation.NavigationComponent

@Composable
fun MainComponent() {
    val controller = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationComponent(controller = controller) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            NavigationComponent(controller)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainComponentPreview() {
    MainComponent()
}
