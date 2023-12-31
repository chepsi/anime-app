package chepsi.anime.app.presentation.screens.search.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import chepsi.anime.app.presentation.screens.search.SearchScreenState
import chepsi.anime.app.presentation.theme.AnimeAppTheme
import coil.compose.AsyncImage

@Composable
fun SearchMainComponent(
    onSearchImageUsingUriAction: (Uri) -> Unit,
    onUpdateUri: (Uri?) -> Unit,
    onUpdateUrl: (String) -> Unit,
    onSearchImageUsingUrlAction: (String) -> Unit,
    screenState: SearchScreenState
) {
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> onUpdateUri(uri) }
    )
    Column(modifier = Modifier.fillMaxSize()) {
        screenState.imageUri?.let {
            AsyncImage(
                model = it,
                contentDescription = "Image to search",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.FillBounds
            )
        }
        screenState.imageUrl?.let {
            AsyncImage(
                model = it,
                contentDescription = "Image to search",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.FillBounds
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = screenState.imageUrl ?: "",
                onValueChange = { onUpdateUrl(it) },
                singleLine = true,
                label = { Text("Image Url") },
                modifier = Modifier.fillMaxWidth()
            )
            Text("-- OR --")
            OutlinedButton(
                onClick = {
                    singlePhotoPickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )
                }
            ) {
                if (screenState.imageUri == null) {
                    Text(text = "Select an Image From Gallery")
                } else {
                    Text(text = "Select another Image")
                }
            }
        }
        screenState.imageUri?.let {
            Button(
                onClick = {
                    onSearchImageUsingUriAction(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                if (screenState.isLoading) {
                    CircularProgressIndicator(color = Color.Red)
                } else {
                    Text("Search Anime")
                }
            }
        }

        screenState.imageUrl?.let {
            Button(
                onClick = {
                    onSearchImageUsingUrlAction(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                if (screenState.isLoading) {
                    CircularProgressIndicator(color = Color.Red)
                } else {
                    Text("Search Anime")
                }
            }
        }

        if (screenState.title.isNotBlank() && !screenState.isError) {
            Text(
                "Title: ${screenState.title}",
                modifier = Modifier.padding(start = 20.dp, bottom = 10.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                "Episode: ${screenState.episode}",
                modifier = Modifier.padding(start = 20.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        if (screenState.isError && screenState.errorMessage != null) {
            Text("Error: ${screenState.errorMessage}", modifier = Modifier.padding(20.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchInitialComponentPreview() {
    AnimeAppTheme {
        SearchMainComponent(
            onSearchImageUsingUriAction = {},
            onUpdateUri = {},
            screenState = SearchScreenState(),
            onUpdateUrl = {},
            onSearchImageUsingUrlAction = {}
        )
    }
}
