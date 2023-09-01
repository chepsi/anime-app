package chepsi.anime.app.datasource.local.database

import android.provider.BaseColumns

object AnimeContract {
    object AnimeEntry : BaseColumns {
        const val TABLE_NAME = "anime"
        const val COLUMN_NAME_ANIME_ID = "id"
        const val COLUMN_NAME_URL = "url"
        const val COLUMN_NAME_IMAGE_URL = "image_url"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_SCORE = "score"
        const val COLUMN_NAME_RANK = "rank"
        const val COLUMN_NAME_POPULARITY = "popularity"
        const val COLUMN_NAME_FAVORITES = "favourites"
        const val COLUMN_NAME_YEAR = "year"
        const val COLUMN_NAME_RATING = "rating"
        const val COLUMN_NAME_SYNOPSIS = "synopsis"
        const val COLUMN_NAME_TRAILER_URL = "trailer_url"
        const val COLUMN_NAME_IS_FAVOURITE = "is_favourite"
        const val COLUMN_NAME_STATUS = "status"
        const val COLUMN_NAME_EPISODES = "episodes"
        const val COLUMN_NAME_SOURCE = "source"
        const val COLUMN_NAME_CREATED_AT = "created_at"
    }
}
