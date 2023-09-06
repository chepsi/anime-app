package chepsi.anime.app.datasource.remote.search.source

import chepsi.anime.app.datasource.remote.search.model.SearchAnimeApiResponse
import chepsi.anime.app.datasource.remote.utils.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitFormWithBinaryData
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders

class SearchRemoteDataSource(private val httpClient: HttpClient) : SearchRemoteSource {
    private val searchImageUrl = "https://api.trace.moe/search"
    override suspend fun searchImage(request: ByteArray) =
        httpClient.submitFormWithBinaryData(
            url = searchImageUrl,
            formData = formData {
                append("image", request, Headers.build {
                    append(HttpHeaders.ContentType, "image/jpeg")
                    append(HttpHeaders.ContentDisposition, "filename=image.png")
                })
            }
        ).body<SearchAnimeApiResponse>()

    override suspend fun searchImage(request: String) = safeApiCall {
        httpClient.get(searchImageUrl) {
            parameter("url", request)
        }.body<SearchAnimeApiResponse>()
    }

}
