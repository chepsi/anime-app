package chepsi.anime.app.domain.favorite.repository

import chepsi.anime.app.domain.home.model.AnimeDomainModel
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    suspend fun fetchFavorites(): Flow<List<AnimeDomainModel>>
}