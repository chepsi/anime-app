package chepsi.anime.app.data.favorite.repository

import chepsi.anime.app.data.home.mappers.toData
import chepsi.anime.app.data.home.mappers.toDomain
import chepsi.anime.app.datasource.local.anime.AnimeLocalSource
import chepsi.anime.app.datasource.local.anime.model.AnimeEntityModel
import chepsi.anime.app.domain.favorite.repository.FavoriteRepository
import chepsi.anime.app.domain.home.model.AnimeDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

class FavoriteDataRepository(
    private val animeLocalSource: AnimeLocalSource
) : FavoriteRepository {
    override suspend fun fetchFavorites(): Flow<List<AnimeDomainModel>> {
        return animeLocalSource.fetchAnime().filterNotNull().map { it.mapToDomain() }
    }

    private fun List<AnimeEntityModel>.mapToDomain() =
        map { anime -> anime.toData().toDomain() }.filter { it.isFavorite }
}
