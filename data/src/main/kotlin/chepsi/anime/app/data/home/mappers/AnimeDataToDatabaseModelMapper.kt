package chepsi.anime.app.data.home.mappers

import chepsi.anime.app.data.home.model.AnimeDataModel
import chepsi.anime.app.datasource.local.anime.model.AnimeEntityModel


fun AnimeDataModel.toDatabase(createdAt: Long) = AnimeEntityModel(
    animeId = animeId,
    url = url,
    imageUrl = imageUrl,
    title = title,
    score = score,
    rank = rank,
    popularity = popularity,
    favorites = favorites,
    year = year,
    rating = rating,
    synopsis = synopsis,
    trailerUrl = trailerUrl,
    isFavourite = isFavourite,
    status = status,
    episodes = episodes,
    source = source,
    createdAt = createdAt
)
