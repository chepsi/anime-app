package chepsi.anime.app.presentation.screens.search

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import chepsi.anime.app.domain.search.model.SearchResponseDomainModel
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
                updateState(response)
            }
        }
    }

    fun onSearchUsingImageAction(request: String) {
        setIsLoading()
        viewModelScope.launch {
            searchRepository.searchImage(request).collect { response ->
                updateState(response)
            }
        }
    }

    private fun updateState(response: SearchResponseDomainModel) {
        searchScreenState = searchScreenState.copy(
            title = response.title,
            episode = response.episode,
            isLoading = false,
            errorMessage = response.error,
            isError = !response.error.isNullOrBlank()
        )
    }

    fun onUpdateUriAction(uri: Uri) {
        searchScreenState = searchScreenState.copy(
            imageUri = uri,
            imageUrl = null,
            title = "",
            episode = "",
            errorMessage = null,
            isError = false
        )
    }

    fun onUpdateUrlAction(url: String) {
        searchScreenState = searchScreenState.copy(
            imageUri = null,
            imageUrl = url,
            title = "",
            episode = "",
            errorMessage = null,
            isError = false
        )
    }

    private fun setIsLoading() {
        searchScreenState = searchScreenState.copy(isLoading = true)
    }
}
