package chepsi.anime.app.presentation.screens.home

import io.mockk.clearAllMocks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class HomeViewModelTest {
    private lateinit var classUnderTest: HomeViewModel

    @BeforeEach
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        classUnderTest = HomeViewModel()
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }

    @Test
    fun `Given home information When onFetchAnimeAction Then updates the state`() {
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
                    score = "9.1"
                )
            }
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `Given home information When onFetchAnimeAction Then 25 items are shown`() {
        // When
        classUnderTest.onFetchAnimeAction()
        val actual = classUnderTest.homeScreenState

        // Then
        assertEquals(25, actual.anime.size)
    }
}
