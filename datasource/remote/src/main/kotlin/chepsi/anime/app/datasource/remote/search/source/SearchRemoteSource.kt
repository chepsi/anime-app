package chepsi.anime.app.datasource.remote.search.source

import chepsi.anime.app.datasource.remote.search.model.SearchAnimeApiResponse

interface SearchRemoteSource {
    suspend fun searchImage(request: ByteArray): SearchAnimeApiResponse
    suspend fun searchImage(request: String): SearchAnimeApiResponse
}
