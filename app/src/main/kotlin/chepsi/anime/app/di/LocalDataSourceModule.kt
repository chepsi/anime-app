package chepsi.anime.app.di

import android.content.ContentValues
import android.content.Context
import chepsi.anime.app.datasource.local.anime.AnimeLocalDataSource
import chepsi.anime.app.datasource.local.anime.AnimeLocalSource
import chepsi.anime.app.datasource.local.database.AnimeDbHelper
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Provides
    @Reusable
    fun providesContentValues() = ContentValues()

    @Provides
    @Reusable
    fun providesDatabase(@ApplicationContext context: Context) = AnimeDbHelper(context)

    @Provides
    fun providesAnimeLocalSource(
        contentValues: ContentValues,
        dbHelper: AnimeDbHelper
    ): AnimeLocalSource = AnimeLocalDataSource(
        dbHelper,
        contentValues
    )
}