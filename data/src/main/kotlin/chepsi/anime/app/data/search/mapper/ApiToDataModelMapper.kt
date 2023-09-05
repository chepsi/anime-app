package chepsi.anime.app.data.search.mapper

import chepsi.anime.app.data.search.model.SearchResponseDataModel
import chepsi.anime.app.datasource.remote.search.model.SearchAnimeApiResponse

fun SearchAnimeApiResponse.Result.toData(): SearchResponseDataModel = SearchResponseDataModel(
    title = filename.orEmpty(),
    episode = episode.toString()
)
