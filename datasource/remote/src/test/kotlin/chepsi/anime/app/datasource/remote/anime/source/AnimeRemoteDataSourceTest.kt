package chepsi.anime.app.datasource.remote.anime.source

import chepsi.anime.app.datasource.remote.anime.model.AnimeApiResponseModel
import chepsi.anime.app.datasource.remote.utils.HttpClientFactory
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.headersOf
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AnimeRemoteDataSourceTest {
    private lateinit var classUnderTest: AnimeRemoteDataSource

    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun `Given success network call When fetchAnime Then returns correct response`() = runBlocking {
        // Given
        val mockEngine = MockEngine {
            respond(
                content = mockAnimeResponse,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val client = HttpClientFactory().create(mockEngine)
        classUnderTest = AnimeRemoteDataSource(client)

        // When
        val actual = classUnderTest.fetchAnime()
        val expected = json.decodeFromString<AnimeApiResponseModel>(
            mockAnimeResponse
        )

        // Then
        assertEquals(expected, actual)
    }
}
