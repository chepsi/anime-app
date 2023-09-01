package chepsi.anime.app.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import chepsi.anime.app.domain.home.repository.HomeRepository
import chepsi.anime.app.presentation.screens.home.mapper.toPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
    var homeScreenState by mutableStateOf(HomeScreenState())

    fun onFetchAnimeAction() {
        viewModelScope.launch {
            homeRepository.fetchHomeDashboardInformation().collect { homeDashboardInformation ->
                homeScreenState = homeScreenState.copy(
                    isLoading = false,
                    anime = homeDashboardInformation.anime.toPresentation()
                )
            }
        }
    }
}
