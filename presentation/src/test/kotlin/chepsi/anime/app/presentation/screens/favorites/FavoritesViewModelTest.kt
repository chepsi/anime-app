package chepsi.anime.app.presentation.screens.favorites

import chepsi.anime.app.domain.favorite.repository.FavoriteRepository
import chepsi.anime.app.domain.home.model.AnimeDomainModel
import chepsi.anime.app.presentation.screens.favorites.model.FavoritesScreenState
import chepsi.anime.app.presentation.screens.home.model.AnimePresentationModel
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class FavoritesViewModelTest {

    private lateinit var classUnderTest: FavoritesViewModel
    private val favoriteRepository = mockk<FavoriteRepository>()


    @BeforeEach
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        classUnderTest = FavoritesViewModel(favoriteRepository)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }

    @Test
    fun `Given home information When onFetchAnimeAction Then updates the state`() {
        // Given
        coEvery { favoriteRepository.fetchFavorites() } returns mockDomainResponse()

        // When
        classUnderTest.onFetchFavorites()
        val actual = classUnderTest.favoritesScreenState

        // Then
        val expected = FavoritesScreenState(
            anime = (0 until 25).map {
                AnimePresentationModel(
                    name = "Fullmetal Alchemist: Brotherhood",
                    imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
                    score = 9.1,
                    isFavorite = false,
                    id = 1
                )
            },
            isEmpty = false
        )
        assertEquals(expected, actual)
    }

    private fun mockDomainResponse() = flowOf(
        (0 until 25).map {
            AnimeDomainModel(
                title = "Fullmetal Alchemist: Brotherhood",
                imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
                score = 9.1,
                isFavorite = false,
                id = 1
            )
        }
    )
}