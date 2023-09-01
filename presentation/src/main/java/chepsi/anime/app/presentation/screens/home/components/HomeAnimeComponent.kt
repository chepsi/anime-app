package chepsi.anime.app.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import chepsi.anime.app.presentation.screens.home.AnimePresentationModel
import chepsi.anime.app.presentation.theme.AnimeAppTheme
import chepsi.anime.app.presentation.theme.PearlWhite
import coil.compose.AsyncImage

@Composable
fun HomeAnimeComponent(anime: AnimePresentationModel) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(PearlWhite)
    ) {
        AsyncImage(
            model = anime.imageUrl,
            contentDescription = anime.name,
            modifier = Modifier.fillMaxWidth().aspectRatio(0.8f),
            contentScale = ContentScale.FillWidth
        )
        Text(anime.name, modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp))
        Text(anime.score.toString(), modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp))
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Preview
@Composable
private fun HomeAnimeComponentPreview() {
    val anime = AnimePresentationModel(
        name = "Fullmetal Alchemist: Brotherhood",
        imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
        score = 9.1
    )
    AnimeAppTheme {
        HomeAnimeComponent(anime = anime)
    }
}
