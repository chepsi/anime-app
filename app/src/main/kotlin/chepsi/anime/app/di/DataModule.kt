package chepsi.anime.app.di

import chepsi.anime.app.data.home.repository.HomeDataRepository
import chepsi.anime.app.domain.home.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideHomeRepository(): HomeRepository = HomeDataRepository()
}
