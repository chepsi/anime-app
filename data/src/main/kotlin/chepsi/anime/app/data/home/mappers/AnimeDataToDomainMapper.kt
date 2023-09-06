package chepsi.anime.app.data.home.mappers

import chepsi.anime.app.data.home.model.AnimeDataModel
import chepsi.anime.app.domain.home.model.AnimeDomainModel

fun AnimeDataModel.toDomain() = AnimeDomainModel(
    title = title,
    imageUrl = imageUrl,
    score = score,
    isFavorite = isFavourite,
    id = animeId
)
