package chepsi.anime.app.data.home.mappers

import chepsi.anime.app.data.home.model.AnimeDataModel
import chepsi.anime.app.data.utils.orZero
import chepsi.anime.app.datasource.remote.anime.model.AnimeApiResponseModel

object AnimeApiToDataMapper {

    fun AnimeApiResponseModel.Data.toData() = AnimeDataModel(
        animeId = malId ?: 0,
        url = url.orEmpty(),
        imageUrl = images?.jpg?.imageUrl.orEmpty(),
        title = titleEnglish.orEmpty(),
        score = score.orZero(),
        rank = rank.orZero(),
        popularity = popularity.orZero(),
        favorites = favorites.orZero(),
        year = year.orZero(),
        rating = rating.orEmpty(),
        synopsis = synopsis.orEmpty(),
        trailerUrl = trailer?.url.orEmpty(),
        isFavourite = false,
        status = status.orEmpty(),
        episodes = episodes.orZero(),
        source = source.orEmpty()
    )
}
