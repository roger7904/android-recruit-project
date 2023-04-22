package `in`.hahow.android_recruit_project.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
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
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.Course
import com.skydoves.landscapist.glide.GlideImage
import `in`.hahow.android_recruit_project.R

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
                items((homeUiState as HomeUiState.Success).courses) { course ->
                    when (course) {
                        is Course.Incubating -> {
                            IncubatingCourseItem(
                                imageUrl = course.coverImageUrl,
                                statusString = stringResource(id = R.string.status_incubating)
                            )
                        }
                        is Course.Success -> {
                            SuccessCourseItem(
                                course = course
                            )
                        }
                        is Course.Published -> {
                            PublishedCourseItem(
                                course = course
                            )
                        }
                    }
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
fun IncubatingCourseItem(
    imageUrl: String,
    statusString: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.3f)
            .aspectRatio(1.6f),
        contentAlignment = Alignment.BottomEnd,
    ) {
        GlideImage(
            imageModel = { imageUrl },
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
        Card{
            Text(
                text = statusString,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun SuccessCourseItem(course: Course.Success) {

}

@Composable
fun PublishedCourseItem(course: Course.Published) {

}