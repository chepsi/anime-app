package chepsi.anime.app.presentation.screens.home.mapper

import chepsi.anime.app.domain.home.model.AnimeDomainModel
import chepsi.anime.app.presentation.screens.home.model.AnimePresentationModel

fun AnimeDomainModel.toPresentation() = AnimePresentationModel(
    name = title,
    imageUrl = imageUrl,
    score = score,
    isFavorite = isFavorite,
    id = id
)

fun List<AnimeDomainModel>.toPresentation() = map { anime -> anime.toPresentation() }
