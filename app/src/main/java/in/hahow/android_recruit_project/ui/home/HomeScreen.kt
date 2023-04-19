package `in`.hahow.android_recruit_project.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.skydoves.landscapist.glide.GlideImage
import `in`.hahow.android_recruit_project.ui.theme.HahowTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeUiState: HomeUiState by viewModel.homeUiState.collectAsState()

    LazyColumn(
        modifier = modifier,
    ) {
        when (homeUiState) {
            is HomeUiState.Loading -> {
                item {
                    Box(modifier = Modifier.fillParentMaxSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
            is HomeUiState.Success -> {
                items((homeUiState as HomeUiState.Success).courses.data) { course ->
                    GlideImage(
                        modifier = modifier,
                        imageModel = { course.coverImageUrl },
                        loading = {
                            Box(
                                modifier = Modifier.background(
                                    brush = Brush.linearGradient(
                                        listOf(Gray, Color.White)
                                    )
                                )
                            )
                        },
                        failure = {
                            Text(text = "image request failed.")
                        }
                    )
                }
            }
            is HomeUiState.Error -> {
                item {
                    Text(
                        text = "Error",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        color = MaterialTheme.colorScheme.onBackground
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HahowTheme {
        Greeting("Android")
    }
}