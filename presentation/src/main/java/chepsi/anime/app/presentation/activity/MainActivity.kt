package chepsi.anime.app.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import chepsi.anime.app.presentation.components.main.MainComponent
import chepsi.anime.app.presentation.theme.AnimeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeAppTheme {
                MainComponent()
            }
        }
    }
}
