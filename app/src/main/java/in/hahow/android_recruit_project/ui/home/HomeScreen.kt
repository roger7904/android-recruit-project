package `in`.hahow.android_recruit_project.ui.home

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.Course
import `in`.hahow.android_recruit_project.R
import `in`.hahow.android_recruit_project.ui.home.component.CourseItem
import `in`.hahow.android_recruit_project.ui.theme.Incubating
import `in`.hahow.android_recruit_project.ui.theme.Published
import `in`.hahow.android_recruit_project.ui.theme.Success

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
                            CourseItem(
                                modifier = Modifier.fillParentMaxWidth(),
                                title = course.title,
                                imageUrl = course.coverImageUrl,
                                statusString = stringResource(id = R.string.status_incubating),
                                statusBackgroundColor = Incubating,
                                progressString = course.progressText,
                                progressBackgroundColor = Incubating,
                                progress = course.progress,
                                countDown = course.countDown
                            )
                        }
                        is Course.Success -> {
                            CourseItem(
                                modifier = Modifier.fillParentMaxWidth(),
                                title = course.title,
                                imageUrl = course.coverImageUrl,
                                statusString = stringResource(id = R.string.status_success),
                                statusBackgroundColor = Success,
                                progressString = course.progressText,
                                progressBackgroundColor = Success,
                                progress = course.progress,
                            )
                        }
                        is Course.Published -> {
                            CourseItem(
                                modifier = Modifier.fillParentMaxWidth(),
                                title = course.title,
                                imageUrl = course.coverImageUrl,
                                statusString = stringResource(id = R.string.status_published),
                                statusBackgroundColor = Published,
                                progressString = course.progressText,
                                progressBackgroundColor = Published,
                                progress = course.progress,
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