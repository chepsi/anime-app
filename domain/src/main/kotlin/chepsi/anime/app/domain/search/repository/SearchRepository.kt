package chepsi.anime.app.domain.search.repository

import chepsi.anime.app.domain.search.model.SearchResponseDomainModel
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun searchImage(request: ByteArray): Flow<SearchResponseDomainModel>
    suspend fun searchImage(request: String): Flow<SearchResponseDomainModel>
}
