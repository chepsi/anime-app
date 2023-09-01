package chepsi.anime.app.domain.home.repository

import chepsi.anime.app.domain.home.model.HomeDashboardDomainModel
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun fetchHomeDashboardInformation(): Flow<HomeDashboardDomainModel>
}
