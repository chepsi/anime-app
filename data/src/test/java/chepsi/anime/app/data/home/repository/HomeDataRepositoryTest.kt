package chepsi.anime.app.data.home.repository

import chepsi.anime.app.domain.home.model.AnimeDomainModel
import chepsi.anime.app.domain.home.model.HomeDashboardDomainModel
import io.mockk.clearAllMocks
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class HomeDataRepositoryTest {
    private lateinit var classUnderTest: HomeDataRepository

    @BeforeEach
    fun setup() {
        classUnderTest = HomeDataRepository()
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `When fetchHomeDashboardInformation Then returns correct data`() = runBlocking {
        // When
        var actual: HomeDashboardDomainModel? = null
        classUnderTest.fetchHomeDashboardInformation().collect {
            actual = it
        }

        // Then
        val expected = HomeDashboardDomainModel(
            anime = (0 until 25).map {
                AnimeDomainModel(
                    name = "Fullmetal Alchemist: Brotherhood",
                    imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
                    score = "9.1"
                )
            }
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `When fetchHomeDashboardInformation Then returns 25 items`() = runBlocking {
        // When
        var actual = 0
        classUnderTest.fetchHomeDashboardInformation().collect {
            actual = it.anime.size
        }

        // Then
        val expected = 25
        assertEquals(expected, actual)
    }
}
