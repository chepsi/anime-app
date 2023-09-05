package chepsi.anime.app.presentation.screens.search

import android.net.Uri

data class SearchScreenState(
    val title: String = "",
    val episode: String = "",
    val errorMessage: String? = null,
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val imageUri: Uri? = null,
    val imageUrl: String? = null
)
