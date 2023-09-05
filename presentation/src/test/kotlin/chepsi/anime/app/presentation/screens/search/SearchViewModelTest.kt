package chepsi.anime.app.presentation.screens.search

import android.net.Uri
import chepsi.anime.app.domain.search.model.SearchResponseDomainModel
import chepsi.anime.app.domain.search.repository.SearchRepository
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

class SearchViewModelTest {
    private lateinit var classUnderTest: SearchViewModel
    private val searchRepository: SearchRepository = mockk()

    @BeforeEach
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        classUnderTest = SearchViewModel(searchRepository)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }

    @Test
    fun `When onUpdateUriAction Then updates state`() {
        // Given
        val givenUri = mockk<Uri>()

        // When
        classUnderTest.onUpdateUriAction(givenUri)
        val actual = classUnderTest.searchScreenState

        // Then
        val expectedState = SearchScreenState(imageUri = givenUri)
        assertEquals(expectedState, actual)
    }

    @Test
    fun `When onUpdateUrlAction Then updates state`() {
        // Given
        val givenUrl = "www.google.com"

        // When
        classUnderTest.onUpdateUrlAction(givenUrl)
        val actual = classUnderTest.searchScreenState

        // Then
        val expectedState = SearchScreenState(imageUrl = givenUrl)
        assertEquals(expectedState, actual)
    }

    @Test
    fun `Given success response When onSearchUsingImageAction Then updates state`() {
        // Given
        val givenInput = byteArrayOf(0, 12, 2)
        coEvery { searchRepository.searchImage(givenInput) }.returns(
            flowOf(
                SearchResponseDomainModel(title = "home", episode = "2", error = null)
            )
        )

        // When
        classUnderTest.onSearchUsingImageAction(givenInput)
        val actual = classUnderTest.searchScreenState

        // Then
        val expected = SearchScreenState(
            title = "home",
            episode = "2",
            isLoading = false
        )

        assertEquals(expected, actual)
    }

    @Test
    fun `Given success response When onSearchUsingImageAction using url Then updates state`() {
        // Given
        val givenInput = "www.google.com"
        coEvery { searchRepository.searchImage(givenInput) }.returns(
            flowOf(
                SearchResponseDomainModel(title = "home", episode = "2", error = null)
            )
        )

        // When
        classUnderTest.onSearchUsingImageAction(givenInput)
        val actual = classUnderTest.searchScreenState

        // Then
        val expected = SearchScreenState(
            title = "home",
            episode = "2",
            isLoading = false
        )

        assertEquals(expected, actual)
    }
}