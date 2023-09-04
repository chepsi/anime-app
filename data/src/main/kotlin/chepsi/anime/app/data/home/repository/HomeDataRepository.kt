package chepsi.anime.app.data.home.repository

import chepsi.anime.app.data.home.mappers.AnimeApiToDataMapper.toData
import chepsi.anime.app.data.home.mappers.toData
import chepsi.anime.app.data.home.mappers.toDatabase
import chepsi.anime.app.data.home.mappers.toDomain
import chepsi.anime.app.data.home.model.AnimeDataModel
import chepsi.anime.app.data.utils.DateTimeUtils
import chepsi.anime.app.datasource.local.anime.AnimeLocalSource
import chepsi.anime.app.datasource.local.anime.model.AnimeEntityModel
import chepsi.anime.app.datasource.remote.anime.model.AnimeApiResponseModel
import chepsi.anime.app.datasource.remote.anime.source.AnimeRemoteSource
import chepsi.anime.app.domain.home.model.HomeDashboardDomainModel
import chepsi.anime.app.domain.home.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.firstOrNull

class HomeDataRepository(
    private val animeRemoteSource: AnimeRemoteSource,
    private val animeLocalSource: AnimeLocalSource,
    private val dateTimeUtils: DateTimeUtils
) : HomeRepository {
    private val sharedFlow = MutableSharedFlow<HomeDashboardDomainModel>(1)
    val flow: Flow<HomeDashboardDomainModel> get() = sharedFlow

    override suspend fun fetchHomeDashboardInformation(): Flow<HomeDashboardDomainModel> {
        if (isCacheEmpty()) {
            val fromLocal = fetchFromLocal()
            if (!fromLocal.isNullOrEmpty() && fromLocal.isNotEmpty()) {
                sharedFlow.emit(HomeDashboardDomainModel(anime = fromLocal.mapToDomain()))
            } else {
                val items = fetchFromRemote()
                sharedFlow.emit(HomeDashboardDomainModel(anime = items.map { it.toDomain() }))
                    .also {
                        saveToCache(items)
                    }
            }
        }
        return flow
    }

    private fun isCacheEmpty() = sharedFlow.replayCache.isEmpty()

    override suspend fun refreshDatabase() {
        val anime = fetchFromRemote()
        saveToCache(anime)
        sharedFlow.emit(HomeDashboardDomainModel(anime.map { it.toDomain() }))
    }

    private suspend fun saveToCache(anime: List<AnimeDataModel>) {
        val currentTime = dateTimeUtils.today()
        val databaseModel = anime.map { it.toDatabase(currentTime) }
        animeLocalSource.saveAnimes(databaseModel)
    }

    private suspend fun fetchFromLocal() = animeLocalSource.fetchAnime().firstOrNull()

    private suspend fun fetchFromRemote(): List<AnimeDataModel> {
        return animeRemoteSource.fetchAnime().toData()
    }

    private fun AnimeApiResponseModel.toData() = data?.map { it.toData() } ?: emptyList()

    private fun List<AnimeEntityModel>.mapToDomain() = map { anime -> anime.toData().toDomain() }
}
