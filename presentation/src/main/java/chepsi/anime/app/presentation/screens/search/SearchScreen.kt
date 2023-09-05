package chepsi.anime.app.presentation.screens.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import chepsi.anime.app.presentation.screens.search.components.SearchMainComponent
import chepsi.anime.app.presentation.theme.AnimeAppTheme

@Composable
fun SearchScreen(searchViewModel: SearchViewModel = hiltViewModel()) {
    val state = searchViewModel.searchScreenState

    val context = LocalContext.current
    SearchMainComponent(
        onUpdateUri = { uri ->
            uri?.let { searchViewModel.onUpdateUriAction(it) }
        },
        onSearchImageUsingUriAction = {
            val imageStream = context.contentResolver.openInputStream(it)
            imageStream?.readBytes()?.let { imageByteArray ->
                searchViewModel.onSearchUsingImageAction(imageByteArray)
            }
            imageStream?.close()
        },
        screenState = state,
        onUpdateUrl = { url ->
            searchViewModel.onUpdateUrlAction(url)
        },
        onSearchImageUsingUrlAction = {
            searchViewModel.onSearchUsingImageAction(it)
        }
    )
}

@Preview
@Composable
private fun SearchScreenPreview() {
    AnimeAppTheme { SearchScreen() }
}
