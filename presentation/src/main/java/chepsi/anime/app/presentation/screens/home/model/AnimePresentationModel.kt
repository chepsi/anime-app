package chepsi.anime.app.presentation.screens.home.model

data class AnimePresentationModel(
    val name: String,
    val imageUrl: String,
    val score: Double,
    val isFavorite: Boolean,
    val id: Int
)
