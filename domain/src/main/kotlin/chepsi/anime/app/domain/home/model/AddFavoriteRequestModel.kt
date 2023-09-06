package chepsi.anime.app.domain.home.model

data class AddFavoriteRequestModel(
    val animeId: Int,
    val isFavorite: Boolean
)
