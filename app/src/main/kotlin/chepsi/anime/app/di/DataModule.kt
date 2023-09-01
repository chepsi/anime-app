package chepsi.anime.app.di

import chepsi.anime.app.data.home.repository.HomeDataRepository
import chepsi.anime.app.data.utils.DateTimeUtils
import chepsi.anime.app.datasource.local.anime.AnimeLocalSource
import chepsi.anime.app.datasource.remote.anime.source.AnimeRemoteSource
import chepsi.anime.app.domain.home.repository.HomeRepository
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
}
