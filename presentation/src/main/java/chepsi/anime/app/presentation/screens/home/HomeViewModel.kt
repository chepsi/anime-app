package chepsi.anime.app.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    var homeScreenState by mutableStateOf(HomeScreenState())

    fun onFetchAnimeAction() {
        viewModelScope.launch {
            homeScreenState = HomeScreenState(
                isLoading = true,
                anime = (0..25).map {
                    AnimePresentationModel(
                        name = "Fullmetal Alchemist: Brotherhood",
                        imageUrl = "https://cdn.myanimelist.net/images/anime/1208/94745.jpg",
                        score = "9.1"
                    )
                }
            )
        }
    }
}
