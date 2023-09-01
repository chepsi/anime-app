package chepsi.anime.app.data.home.repository

import chepsi.anime.app.data.home.mappers.AnimeApiToDataMapper.toData
import chepsi.anime.app.data.home.mappers.toDomain
import chepsi.anime.app.datasource.remote.anime.source.AnimeRemoteSource
import chepsi.anime.app.domain.home.model.HomeDashboardDomainModel
import chepsi.anime.app.domain.home.repository.HomeRepository
import kotlinx.coroutines.flow.flow

class HomeDataRepository(private val animeRemoteSource: AnimeRemoteSource) : HomeRepository {
    override suspend fun fetchHomeDashboardInformation() = flow {
        val response = animeRemoteSource.fetchAnime()
        val dataModel = response.data?.map { it.toData() } ?: emptyList()
        emit(HomeDashboardDomainModel(anime = dataModel.map { it.toDomain() }))
    }
}
