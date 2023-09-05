package chepsi.anime.app.data.search.repository

import chepsi.anime.app.data.search.mapper.toData
import chepsi.anime.app.datasource.remote.search.source.SearchRemoteSource
import chepsi.anime.app.domain.search.model.SearchResponseDomainModel
import chepsi.anime.app.domain.search.repository.SearchRepository
import kotlinx.coroutines.flow.flow

class SearchDataRepository(private val searchRemoteSource: SearchRemoteSource) : SearchRepository {
    override suspend fun searchImage(request: ByteArray) = flow {
        val result = searchRemoteSource.searchImage(request)
        result.result?.map { it?.toData() }?.first()?.let {
            val domain = SearchResponseDomainModel(it.title, it.episode, result.error)
            emit(domain)
        }
    }

    override suspend fun searchImage(request: String) = flow {
        val result = searchRemoteSource.searchImage(request)
        result.result?.map { it?.toData() }?.first()?.let {
            val domain = SearchResponseDomainModel(it.title, it.episode, result.error)
            emit(domain)
        }
    }
}
