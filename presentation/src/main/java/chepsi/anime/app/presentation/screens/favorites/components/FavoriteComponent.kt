package chepsi.anime.app.presentation.screens.favorites.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import chepsi.anime.app.presentation.screens.home.model.AnimePresentationModel
import chepsi.anime.app.presentation.theme.AnimeAppTheme
import chepsi.anime.app.presentation.theme.PrimaryLight
import coil.compose.AsyncImage

@Composable
fun FavoriteComponent(favorite: AnimePresentationModel) {
    Row(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(PrimaryLight)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = favorite.imageUrl,
            contentDescription = favorite.name,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Text(
                text = "Title: ${favorite.name}",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Score: ${favorite.score}",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview
@Composable
private fun FavoriteComponentPreview() {
    val favorite = AnimePresentationModel(
        name = "Fullmetal Alchemist: Brotherhood",
        imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
        score = 9.1,
        isFavorite = true,
        id = 0
    )
    AnimeAppTheme {
        FavoriteComponent(favorite = favorite)
    }
}
