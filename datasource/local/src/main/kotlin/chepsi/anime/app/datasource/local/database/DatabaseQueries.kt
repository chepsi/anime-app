package chepsi.anime.app.datasource.local.database

const val SQL_CREATE_ENTRIES =
    "CREATE TABLE ${AnimeContract.AnimeEntry.TABLE_NAME} (" +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_ANIME_ID} INTEGER PRIMARY KEY," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_URL} TEXT," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_IMAGE_URL} TEXT," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_TITLE} TEXT," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_SCORE} REAL," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_RANK} INTEGER," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_POPULARITY} INTEGER," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_FAVORITES} INTEGER," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_YEAR} INTEGER," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_RATING} TEXT," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_SYNOPSIS} TEXT," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_TRAILER_URL} TEXT," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_IS_FAVOURITE} INTEGER," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_STATUS} TEXT," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_EPISODES} INTEGER," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_SOURCE} TEXT," +
        "${AnimeContract.AnimeEntry.COLUMN_NAME_CREATED_AT} INTEGER)"

const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${AnimeContract.AnimeEntry.TABLE_NAME}"
