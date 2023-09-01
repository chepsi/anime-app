package chepsi.anime.app.data.home.repository

import chepsi.anime.app.data.home.mappers.AnimeApiToDataMapper.toData
import chepsi.anime.app.data.home.mappers.toData
import chepsi.anime.app.data.home.mappers.toDatabase
import chepsi.anime.app.data.home.mappers.toDomain
import chepsi.anime.app.data.home.model.AnimeDataModel
import chepsi.anime.app.data.utils.DateTimeUtils
import chepsi.anime.app.datasource.local.anime.AnimeLocalSource
import chepsi.anime.app.datasource.remote.anime.source.AnimeRemoteSource
import chepsi.anime.app.domain.home.model.HomeDashboardDomainModel
import chepsi.anime.app.domain.home.repository.HomeRepository
import kotlinx.coroutines.flow.flow

class HomeDataRepository(
    private val animeRemoteSource: AnimeRemoteSource,
    private val animeLocalSource: AnimeLocalSource,
    private val dateTimeUtils: DateTimeUtils
) : HomeRepository {
    override suspend fun fetchHomeDashboardInformation() = flow {
        animeLocalSource.fetchAnime().collect {
            val items = if (it.size == 0) {
                refreshDatabase().map { anime -> anime.toDomain() }
            } else {
                it.map { anime -> anime.toData().toDomain() }
            }
            emit(HomeDashboardDomainModel(items))
        }
    }


    private suspend fun refreshDatabase(): List<AnimeDataModel> {
        val response = animeRemoteSource.fetchAnime()
        val dataModel = response.data?.map { it.toData() } ?: emptyList()
        val currentTime = dateTimeUtils.today()
        val entity = dataModel.map { it.toDatabase(currentTime) }
        animeLocalSource.saveAnimes(entity)
        return dataModel
    }
}
