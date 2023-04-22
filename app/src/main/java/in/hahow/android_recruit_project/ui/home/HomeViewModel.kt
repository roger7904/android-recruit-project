package `in`.hahow.android_recruit_project.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.result.*
import com.example.domain.model.Course
import com.example.domain.usecase.GetCoursesResourcesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getCoursesResourcesUseCase: GetCoursesResourcesUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val homeUiState: StateFlow<HomeUiState> = homeUiState(getCoursesResourcesUseCase)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState.Loading,
        )

    private fun homeUiState(getCoursesResourcesUseCase: GetCoursesResourcesUseCase) : Flow<HomeUiState> {
        return getCoursesResourcesUseCase()
            .asResult()
            .map { coursesResult ->
                when (coursesResult) {
                    is Result.Success -> {
                        HomeUiState.Success(coursesResult.data)
                    }
                    is Result.Loading -> {
                        HomeUiState.Loading
                    }
                    is Result.Error -> {
                        HomeUiState.Error
                    }
                    else -> {
                        HomeUiState.Error
                    }
                }
            }
    }
}

sealed interface HomeUiState {
    data class Success(val courses: List<Course>) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}