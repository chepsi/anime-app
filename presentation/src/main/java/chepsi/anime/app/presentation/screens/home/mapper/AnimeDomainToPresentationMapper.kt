package chepsi.anime.app.presentation.screens.home.mapper

import chepsi.anime.app.domain.home.model.AnimeDomainModel
import chepsi.anime.app.presentation.screens.home.AnimePresentationModel

object AnimeDomainToPresentationMapper {
    fun AnimeDomainModel.toPresentation() = AnimePresentationModel(
        name = name,
        imageUrl = imageUrl,
        score = score
    )

    fun List<AnimeDomainModel>.toPresentation() = map { anime -> anime.toPresentation() }
}
