package chepsi.anime.app.presentation.screens.favorites.model

import chepsi.anime.app.presentation.screens.home.model.AnimePresentationModel

data class FavoritesScreenState(
    val anime: List<AnimePresentationModel> = emptyList(),
    val isEmpty: Boolean = true
)
