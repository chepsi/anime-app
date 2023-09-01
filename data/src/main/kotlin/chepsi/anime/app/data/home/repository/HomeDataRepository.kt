package chepsi.anime.app.data.home.repository

import chepsi.anime.app.domain.home.model.AnimeDomainModel
import chepsi.anime.app.domain.home.model.HomeDashboardDomainModel
import chepsi.anime.app.domain.home.repository.HomeRepository
import kotlinx.coroutines.flow.flow

class HomeDataRepository : HomeRepository {
    override suspend fun fetchHomeDashboardInformation() = flow {
        emit(mockResponse())
    }

    private fun mockResponse() = HomeDashboardDomainModel(
        anime = (0 until 25).map {
            AnimeDomainModel(
                name = "Fullmetal Alchemist: Brotherhood",
                imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
                score = "9.1"
            )
        }
    )
}
