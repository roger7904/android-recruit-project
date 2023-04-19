package `in`.hahow.android_recruit_project.ui.home

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCoursesResourcesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getCoursesResourcesUseCase: GetCoursesResourcesUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    init {

        viewModelScope.launch {
            getCoursesResourcesUseCase().collect { data ->
                Log.d("TAG", ": HomeViewModel $data")
            }
        }
    }
}