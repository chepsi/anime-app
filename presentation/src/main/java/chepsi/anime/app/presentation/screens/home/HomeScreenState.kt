package chepsi.anime.app.presentation.screens.home

data class HomeScreenState(
    val isLoading: Boolean = true,
    val anime: List<AnimePresentationModel> = emptyList()
)

data class AnimePresentationModel(
    val name: String,
    val imageUrl: String,
    val score: String
)
