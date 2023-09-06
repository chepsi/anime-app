package chepsi.anime.app.presentation.screens.home

import chepsi.anime.app.presentation.screens.home.model.AnimePresentationModel

data class HomeScreenState(
    val isLoading: Boolean = true,
    val anime: List<AnimePresentationModel> = emptyList()
)
