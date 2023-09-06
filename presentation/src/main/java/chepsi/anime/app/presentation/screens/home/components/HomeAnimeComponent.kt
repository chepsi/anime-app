package chepsi.anime.app.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import chepsi.anime.app.domain.home.model.AddFavoriteRequestModel
import chepsi.anime.app.presentation.screens.home.model.AnimePresentationModel
import chepsi.anime.app.presentation.theme.AnimeAppTheme
import chepsi.anime.app.presentation.theme.PrimaryLight
import coil.compose.AsyncImage

@Composable
fun HomeAnimeComponent(
    anime: AnimePresentationModel,
    onUpdateFavoriteItem: (AddFavoriteRequestModel) -> Unit
) {
    Box {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(PrimaryLight)
                .fillMaxWidth(),
        ) {
            AsyncImage(
                model = anime.imageUrl,
                contentDescription = anime.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.8f),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = anime.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                minLines = 2,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Score: ${anime.score}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
        val favoriteIcon =
            if (anime.isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder

        IconButton(
            onClick = {
                val request = AddFavoriteRequestModel(anime.id, !anime.isFavorite)
                onUpdateFavoriteItem(request)
            },
            modifier = Modifier
                .padding(all = 5.dp)
                .graphicsLayer {
                    scaleX = 1.3f
                    scaleY = 1.3f
                }
                .align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = favoriteIcon,
                contentDescription = "Like",
                tint = Color.Red
            )
        }
    }
}

@Preview
@Composable
private fun HomeAnimeComponentPreview() {
    val anime = AnimePresentationModel(
        name = "Fullmetal Alchemist: Brotherhood",
        imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
        score = 9.1,
        isFavorite = false,
        id = 0
    )
    AnimeAppTheme {
        HomeAnimeComponent(anime = anime, onUpdateFavoriteItem = {})
    }
}

@Preview
@Composable
private fun HomeAnimeComponentFavoritePreview() {
    val anime = AnimePresentationModel(
        name = "Fullmetal Alchemist: Brotherhood",
        imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
        score = 9.1,
        isFavorite = true,
        id = 0
    )
    AnimeAppTheme {
        HomeAnimeComponent(anime = anime, onUpdateFavoriteItem = {})
    }
}
