package chepsi.anime.app.data.home.model

data class AnimeDataModel(
    val animeId: Int,
    val url: String,
    val imageUrl: String,
    val title: String,
    val score: Double,
    val rank: Int,
    val popularity: Int,
    val favorites: Int,
    val year: Int,
    val rating: String,
    val synopsis: String,
    val trailerUrl: String,
    val isFavourite: Boolean,
    val status: String,
    val episodes: Int,
    val source: String
)
