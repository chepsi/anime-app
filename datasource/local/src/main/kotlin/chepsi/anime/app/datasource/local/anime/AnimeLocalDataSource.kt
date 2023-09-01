package chepsi.anime.app.datasource.local.anime

import android.content.ContentValues
import chepsi.anime.app.datasource.local.anime.model.AnimeEntityModel
import chepsi.anime.app.datasource.local.database.AnimeContract
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_ANIME_ID
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_CREATED_AT
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_EPISODES
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_FAVORITES
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_IMAGE_URL
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_IS_FAVOURITE
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_POPULARITY
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_RANK
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_RATING
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_SCORE
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_SOURCE
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_STATUS
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_SYNOPSIS
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_TITLE
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_TRAILER_URL
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_URL
import chepsi.anime.app.datasource.local.database.AnimeContract.AnimeEntry.COLUMN_NAME_YEAR
import chepsi.anime.app.datasource.local.database.AnimeDbHelper
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class AnimeLocalDataSource(
    private val db: AnimeDbHelper,
    private val contentValues: ContentValues
) : AnimeLocalSource {

    override suspend fun fetchAnime() = flow {
        val readable = db.readableDatabase
        val cursor = readable.query(
            AnimeContract.AnimeEntry.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null
        )
        val items = mutableListOf<AnimeEntityModel>()
        with(cursor) {
            while (moveToNext()) {
                val item = AnimeEntityModel(
                    animeId = getInt(getColumnIndexOrThrow(COLUMN_NAME_ANIME_ID)),
                    url = getString(getColumnIndexOrThrow(COLUMN_NAME_URL)),
                    imageUrl = getString(getColumnIndexOrThrow(COLUMN_NAME_IMAGE_URL)),
                    title = getString(getColumnIndexOrThrow(COLUMN_NAME_TITLE)),
                    score = getDouble(getColumnIndexOrThrow(COLUMN_NAME_SCORE)),
                    rank = getInt(getColumnIndexOrThrow(COLUMN_NAME_RANK)),
                    popularity = getInt(getColumnIndexOrThrow(COLUMN_NAME_POPULARITY)),
                    favorites = getInt(getColumnIndexOrThrow(COLUMN_NAME_FAVORITES)),
                    year = getInt(getColumnIndexOrThrow(COLUMN_NAME_YEAR)),
                    rating = getString(getColumnIndexOrThrow(COLUMN_NAME_RATING)),
                    synopsis = getString(getColumnIndexOrThrow(COLUMN_NAME_SYNOPSIS)),
                    trailerUrl = getString(getColumnIndexOrThrow(COLUMN_NAME_TRAILER_URL)),
                    isFavourite = getInt(getColumnIndexOrThrow(COLUMN_NAME_IS_FAVOURITE)) == 1,
                    status = getString(getColumnIndexOrThrow(COLUMN_NAME_STATUS)),
                    episodes = getInt(getColumnIndexOrThrow(COLUMN_NAME_EPISODES)),
                    source = getString(getColumnIndexOrThrow(COLUMN_NAME_SOURCE)),
                    createdAt = getLong(getColumnIndexOrThrow(COLUMN_NAME_CREATED_AT))
                )
                items.add(item)
            }
            close()
            closeDatabase()
        }
        emit(items)
    }

    override suspend fun saveAnimes(request: List<AnimeEntityModel>) {
        runBlocking {
            request.forEach { anime ->
                saveAnime(anime)
            }
        }
        closeDatabase()
    }


    private fun saveAnime(request: AnimeEntityModel) {
        val writeable = db.writableDatabase
        val values = contentValues.apply {
            put(COLUMN_NAME_ANIME_ID, request.animeId)
            put(COLUMN_NAME_URL, request.url)
            put(COLUMN_NAME_IMAGE_URL, request.imageUrl)
            put(COLUMN_NAME_TITLE, request.title)
            put(COLUMN_NAME_SCORE, request.score)
            put(COLUMN_NAME_RANK, request.rank)
            put(COLUMN_NAME_POPULARITY, request.popularity)
            put(COLUMN_NAME_FAVORITES, request.favorites)
            put(COLUMN_NAME_YEAR, request.year)
            put(COLUMN_NAME_RATING, request.rating)
            put(COLUMN_NAME_SYNOPSIS, request.synopsis)
            put(COLUMN_NAME_TRAILER_URL, request.trailerUrl)
            put(COLUMN_NAME_IS_FAVOURITE, request.isFavourite)
            put(COLUMN_NAME_STATUS, request.status)
            put(COLUMN_NAME_EPISODES, request.episodes)
            put(COLUMN_NAME_SOURCE, request.source)
            put(COLUMN_NAME_CREATED_AT, request.createdAt)
        }
        writeable.insert(AnimeContract.AnimeEntry.TABLE_NAME, null, values)
    }

    private fun closeDatabase() {
        db.close()
    }
}
