package chepsi.anime.app.presentation.components.toolbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import chepsi.anime.app.presentation.theme.AnimeAppTheme

@Composable
fun AnimeToolbar(title: String) {
    TopAppBar {
        Text(
            text = title,
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimeToolbarPreview() {
    AnimeAppTheme {
        AnimeToolbar("Home")
    }
}
