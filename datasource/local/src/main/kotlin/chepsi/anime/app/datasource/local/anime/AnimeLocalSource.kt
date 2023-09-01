package chepsi.anime.app.datasource.local.anime

import chepsi.anime.app.datasource.local.anime.model.AnimeEntityModel
import kotlinx.coroutines.flow.Flow

interface AnimeLocalSource {
    suspend fun saveAnimes(request: List<AnimeEntityModel>)
    suspend fun fetchAnime(): Flow<MutableList<AnimeEntityModel>>
}
