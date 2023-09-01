package chepsi.anime.app.datasource.remote.anime.source

import chepsi.anime.app.datasource.remote.anime.model.AnimeApiResponseModel

interface AnimeRemoteSource {
    suspend fun fetchAnime(): AnimeApiResponseModel
}
