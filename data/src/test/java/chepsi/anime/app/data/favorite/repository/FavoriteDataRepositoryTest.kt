package chepsi.anime.app.data.favorite.repository

import chepsi.anime.app.datasource.local.anime.AnimeLocalSource
import chepsi.anime.app.datasource.local.anime.model.AnimeEntityModel
import chepsi.anime.app.domain.home.model.AnimeDomainModel
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

private const val givenTitle = "Fullmetal Alchemist: Brotherhood"
private const val givenImageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg"
private const val givenScore = 9.1

private val givenLocalSourceResponse0 = AnimeEntityModel(
    animeId = 1,
    url = "url",
    imageUrl = givenImageUrl,
    title = givenTitle,
    score = givenScore,
    rank = 1,
    rating = "10",
    popularity = 100,
    favorites = 100,
    year = 2010,
    synopsis = "Some synopsis",
    trailerUrl = "trailer",
    isFavourite = true,
    status = "Airing",
    episodes = 20,
    source = "Manga",
    createdAt = 10L
)

private val givenLocalSourceResponse1 = AnimeEntityModel(
    animeId = 1,
    url = "url",
    imageUrl = givenImageUrl,
    title = givenTitle,
    score = givenScore,
    rank = 1,
    rating = "10",
    popularity = 100,
    favorites = 100,
    year = 2010,
    synopsis = "Some synopsis",
    trailerUrl = "trailer",
    isFavourite = false,
    status = "Airing",
    episodes = 20,
    source = "Manga",
    createdAt = 10L
)
private val givenLocalSourceResponse =
    mutableListOf(givenLocalSourceResponse0, givenLocalSourceResponse1)
private val expected = listOf(
    AnimeDomainModel(
        title = givenTitle,
        imageUrl = givenImageUrl,
        score = givenScore,
        isFavorite = true,
        id = 1
    )
)

class FavoriteDataRepositoryTest {
    private lateinit var classUnderTest: FavoriteDataRepository
    private val animeLocalSource: AnimeLocalSource = mockk()

    @BeforeEach
    fun setup() {
        classUnderTest = FavoriteDataRepository(animeLocalSource)
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given anime response When fetchFavorites Then returns correct data`() =
        runBlocking {
            // Given
            val givenResponse = flowOf(givenLocalSourceResponse)
            coEvery { animeLocalSource.fetchAnime() }.returns(givenResponse)

            // When
            val actual = classUnderTest.fetchFavorites().first()

            // Then

            assertEquals(expected, actual)
        }
}
