package chepsi.anime.app.data.home.repository

import chepsi.anime.app.data.utils.DateTimeUtils
import chepsi.anime.app.datasource.local.anime.AnimeLocalSource
import chepsi.anime.app.datasource.local.anime.model.AnimeEntityModel
import chepsi.anime.app.datasource.remote.anime.model.AnimeApiResponseModel
import chepsi.anime.app.datasource.remote.anime.model.AnimeApiResponseModel.Data.Images
import chepsi.anime.app.datasource.remote.anime.model.AnimeApiResponseModel.Data.Images.Jpg
import chepsi.anime.app.datasource.remote.anime.source.AnimeRemoteSource
import chepsi.anime.app.domain.home.model.AnimeDomainModel
import chepsi.anime.app.domain.home.model.HomeDashboardDomainModel
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
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
private val givenRemoteSourceResponse = AnimeApiResponseModel(
    data = listOf(
        AnimeApiResponseModel.Data(
            images = Images(
                jpg = Jpg(
                    imageUrl = givenImageUrl
                )
            ),
            score = givenScore,
            titleEnglish = givenTitle
        )
    )
)

private val givenLocalSourceResponse = AnimeEntityModel(
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
private val expected0 = HomeDashboardDomainModel(
    anime = listOf(
        AnimeDomainModel(
            title = givenTitle,
            imageUrl = givenImageUrl,
            score = givenScore,
            isFavorite = true,
            id = 1
        )
    )
)

private val expected1 = HomeDashboardDomainModel(
    anime = listOf(
        AnimeDomainModel(
            title = givenTitle,
            imageUrl = givenImageUrl,
            score = givenScore,
            isFavorite = false,
            id = 0
        )
    )
)

class HomeDataRepositoryTest {
    private lateinit var classUnderTest: HomeDataRepository

    private val animeRemoteSource = mockk<AnimeRemoteSource>()
    private val animeLocalSource: AnimeLocalSource = mockk()
    private val dateTimeUtils: DateTimeUtils = mockk()

    @BeforeEach
    fun setup() {
        classUnderTest = HomeDataRepository(animeRemoteSource, animeLocalSource, dateTimeUtils)
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given anime response When fetchHomeDashboardInformation Then returns correct data`() =
        runBlocking {
            // Given
            val givenResponse = flowOf(mutableListOf(givenLocalSourceResponse))
            coEvery { animeLocalSource.fetchAnime() }.returns(givenResponse)
            coEvery { animeRemoteSource.fetchAnime() }.returns(givenRemoteSourceResponse)

            // When
            val actual = classUnderTest.fetchHomeDashboardInformation().first()

            // Then

            assertEquals(expected0, actual)
        }

    @Test
    fun `Given empty anime response When fetchHomeDashboardInformation Then refreshes data`() =
        runBlocking {
            // Given
            coEvery { animeLocalSource.fetchAnime() }.returns(flowOf(mutableListOf()))
            every { dateTimeUtils.today() }.returns(10L)
            coEvery { animeRemoteSource.fetchAnime() }.returns(givenRemoteSourceResponse)
            coEvery { animeLocalSource.saveAnimes(any()) } just runs

            // When
            val actual = classUnderTest.fetchHomeDashboardInformation().first()

            // Then
            assertEquals(expected1, actual)
        }

    @Test
    fun `When refreshDatabase Then fetches from remote`() = runBlocking {
        // Given
        coEvery { animeLocalSource.saveAnimes(any()) } just runs
        coEvery { animeRemoteSource.fetchAnime() }.returns(givenRemoteSourceResponse)
        every { dateTimeUtils.today() }.returns(10L)

        // When
        classUnderTest.refreshDatabase()
        val actual = classUnderTest.flow.first()

        // Then
        coVerify { dateTimeUtils.today() }
        coVerify { animeLocalSource.saveAnimes(any()) }
        assertEquals(expected1, actual)
    }
}
