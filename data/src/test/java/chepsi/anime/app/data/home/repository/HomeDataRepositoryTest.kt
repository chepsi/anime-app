package chepsi.anime.app.data.home.repository

import chepsi.anime.app.datasource.remote.anime.model.AnimeApiResponseModel
import chepsi.anime.app.datasource.remote.anime.model.AnimeApiResponseModel.Data.Images
import chepsi.anime.app.datasource.remote.anime.model.AnimeApiResponseModel.Data.Images.Jpg
import chepsi.anime.app.datasource.remote.anime.source.AnimeRemoteSource
import chepsi.anime.app.domain.home.model.AnimeDomainModel
import chepsi.anime.app.domain.home.model.HomeDashboardDomainModel
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

private const val givenTitle = "Fullmetal Alchemist: Brotherhood"
private const val givenImageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg"
private const val givenScore = 9.1
private val givenResponse = AnimeApiResponseModel(
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

class HomeDataRepositoryTest {
    private lateinit var classUnderTest: HomeDataRepository

    private val animeRemoteSource = mockk<AnimeRemoteSource>()

    @BeforeEach
    fun setup() {
        classUnderTest = HomeDataRepository(animeRemoteSource)
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Given anime response When fetchHomeDashboardInformation Then returns correct data`() =
        runBlocking {
            // Given
            coEvery { animeRemoteSource.fetchAnime() }.returns(givenResponse)

            // When
            var actual: HomeDashboardDomainModel? = null
            classUnderTest.fetchHomeDashboardInformation().collect {
                actual = it
            }

            // Then
            val expected = HomeDashboardDomainModel(
                anime = listOf(
                    AnimeDomainModel(
                        title = givenTitle,
                        imageUrl = givenImageUrl,
                        score = givenScore
                    )
                )
            )

            assertEquals(expected, actual)
        }
}
