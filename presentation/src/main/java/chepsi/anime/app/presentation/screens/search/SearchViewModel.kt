package chepsi.anime.app.presentation.screens.search

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import chepsi.anime.app.domain.search.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {
    var searchScreenState: SearchScreenState by mutableStateOf(SearchScreenState())

    fun onSearchUsingImageAction(request: ByteArray) {
        setIsLoading()
        viewModelScope.launch {
            searchRepository.searchImage(request).collect { response ->
                searchScreenState = searchScreenState.copy(
                    title = response.title,
                    episode = response.episode,
                    isLoading = false
                )
            }
        }
    }

    fun onSearchUsingImageAction(request: String) {
        setIsLoading()
        viewModelScope.launch {
            searchRepository.searchImage(request).collect { response ->
                searchScreenState = searchScreenState.copy(
                    title = response.title,
                    episode = response.episode,
                    isLoading = false
                )
            }
        }
    }

    fun onUpdateUriAction(uri: Uri) {
        searchScreenState = searchScreenState.copy(
            imageUri = uri,
            imageUrl = null
        )
    }

    fun onUpdateUrlAction(url: String) {
        searchScreenState = searchScreenState.copy(
            imageUri = null,
            imageUrl = url
        )
    }

    private fun setIsLoading() {
        searchScreenState = searchScreenState.copy(isLoading = true)
    }
}
