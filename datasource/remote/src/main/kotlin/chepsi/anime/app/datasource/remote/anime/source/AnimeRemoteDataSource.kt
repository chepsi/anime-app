package chepsi.anime.app.datasource.remote.anime.source

import chepsi.anime.app.datasource.remote.anime.model.AnimeApiResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class AnimeRemoteDataSource(private val httpClient: HttpClient) : AnimeRemoteSource {
    override suspend fun fetchAnime() = httpClient.get("https://api.jikan.moe/v4/top/anime") {
        parameter("page", 1)
        parameter("limit", 25)
    }.body<AnimeApiResponseModel>()
}
