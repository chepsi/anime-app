package chepsi.anime.app.datasource.local.anime

import chepsi.anime.app.datasource.local.anime.model.AnimeEntityModel
import chepsi.anime.app.datasource.local.anime.model.AnimeFavouriteUpdateModel
import kotlinx.coroutines.flow.Flow

interface AnimeLocalSource {
    suspend fun saveAnimes(request: List<AnimeEntityModel>)
    suspend fun fetchAnime(): Flow<MutableList<AnimeEntityModel>>
    suspend fun addFavorite(request: AnimeFavouriteUpdateModel)
}
