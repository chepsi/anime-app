package chepsi.anime.app.di

import chepsi.anime.app.data.favorite.repository.FavoriteDataRepository
import chepsi.anime.app.data.home.repository.HomeDataRepository
import chepsi.anime.app.data.search.repository.SearchDataRepository
import chepsi.anime.app.data.utils.DateTimeUtils
import chepsi.anime.app.datasource.local.anime.AnimeLocalSource
import chepsi.anime.app.datasource.remote.anime.source.AnimeRemoteSource
import chepsi.anime.app.datasource.remote.search.source.SearchRemoteSource
import chepsi.anime.app.domain.favorite.repository.FavoriteRepository
import chepsi.anime.app.domain.home.repository.HomeRepository
import chepsi.anime.app.domain.search.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun providesHomeRepository(
        animeRemoteSource: AnimeRemoteSource,
        animeLocalSource: AnimeLocalSource,
        dateTimeUtils: DateTimeUtils
    ): HomeRepository =
        HomeDataRepository(animeRemoteSource, animeLocalSource, dateTimeUtils)

    @Provides
    fun providesDateTimeUtils() = DateTimeUtils()

    @Provides
    fun providesSearchRepository(searchRemoteSource: SearchRemoteSource): SearchRepository =
        SearchDataRepository(searchRemoteSource)

    @Provides
    fun providesFavoriteRepository(animeLocalSource: AnimeLocalSource): FavoriteRepository =
        FavoriteDataRepository(animeLocalSource)
}
