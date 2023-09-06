package chepsi.anime.app.presentation.screens.home

import chepsi.anime.app.domain.home.model.AddFavoriteRequestModel
import chepsi.anime.app.domain.home.model.AnimeDomainModel
import chepsi.anime.app.domain.home.model.HomeDashboardDomainModel
import chepsi.anime.app.domain.home.repository.HomeRepository
import chepsi.anime.app.presentation.screens.home.model.AnimePresentationModel
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class HomeViewModelTest {
    private lateinit var classUnderTest: HomeViewModel
    private val homeRepository = mockk<HomeRepository>()

    @BeforeEach
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        classUnderTest = HomeViewModel(homeRepository)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }

    @Test
    fun `Given home information When onFetchAnimeAction Then updates the state`() {
        // Given
        coEvery { homeRepository.fetchHomeDashboardInformation() } returns mockDomainResponse()

        // When
        classUnderTest.onFetchAnimeAction()
        val actual = classUnderTest.homeScreenState

        // Then
        val expected = HomeScreenState(
            isLoading = false,
            anime = (0 until 25).map {
                AnimePresentationModel(
                    name = "Fullmetal Alchemist: Brotherhood",
                    imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
                    score = 9.1,
                    isFavorite = false,
                    id = 1
                )
            }
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `When onRefreshAction Then runs`() {
        // Given
        coEvery { homeRepository.refreshDatabase() } just runs
        // When
        classUnderTest.onRefreshAction()
        val actual = classUnderTest.homeScreenState

        // Then
        val expected = HomeScreenState(isLoading = true)
        coVerify { homeRepository.refreshDatabase() }
        assertEquals(expected, actual)
    }

    @Test
    fun `When onUpdateFavorite Then runs`() {
        // Given
        val givenRequest = AddFavoriteRequestModel(1, true)
        coEvery { homeRepository.addFavorite(givenRequest) } just runs


        // When
        classUnderTest.onUpdateFavorite(givenRequest)

        // Then
        coVerify { homeRepository.addFavorite(givenRequest) }
    }

    private fun mockDomainResponse() = flowOf(
        HomeDashboardDomainModel(
            anime = (0 until 25).map {
                AnimeDomainModel(
                    title = "Fullmetal Alchemist: Brotherhood",
                    imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
                    score = 9.1,
                    isFavorite = false,
                    id = 1
                )
            }
        )
    )
}
