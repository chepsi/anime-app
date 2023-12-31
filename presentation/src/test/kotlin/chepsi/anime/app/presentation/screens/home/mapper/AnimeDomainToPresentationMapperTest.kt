package chepsi.anime.app.presentation.screens.home.mapper

import chepsi.anime.app.domain.home.model.AnimeDomainModel
import chepsi.anime.app.presentation.screens.home.model.AnimePresentationModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AnimeDomainToPresentationMapperTest {

    @Test
    fun `Given anime domain model When toPresentation Then maps correctly`() {
        val givenDomainModel = listOf(
            AnimeDomainModel(
                title = "Fullmetal Alchemist: Brotherhood",
                imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
                score = 9.1,
                isFavorite = false,
                id = 1
            )
        )
        val expectedModel = listOf(
            AnimePresentationModel(
                name = "Fullmetal Alchemist: Brotherhood",
                imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
                score = 9.1,
                isFavorite = false,
                id = 1
            )
        )

        // When
        val actualModel = givenDomainModel.toPresentation()

        // Then
        assertEquals(expectedModel, actualModel)
        assertEquals(expectedModel.size, actualModel.size)
    }
}
