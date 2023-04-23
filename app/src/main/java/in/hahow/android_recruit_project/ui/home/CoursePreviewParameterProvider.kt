package `in`.hahow.android_recruit_project.ui.home

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.data.model.SuccessCriteria
import com.example.domain.model.Course

class CoursePreviewParameterProvider : PreviewParameterProvider<List<Course>> {
    override val values: Sequence<List<Course>>
        get() = sequenceOf(
            listOf(
                Course.Incubating(
                    title = "Incubating Course",
                    successCriteria = SuccessCriteria(50),
                    numSoldTickets = 20,
                    coverImageUrl = "",
                    isExpired = false,
                    countDown = 10,
                    progressText = "20/50人",
                    progress = 10
                ),
                Course.Published(
                    title = "Published Course",
                    successCriteria = SuccessCriteria(10),
                    numSoldTickets = 30,
                    coverImageUrl = "",
                    progressText = "50%",
                    progress = 50
                ),
                Course.Success(
                    title = "Success Course",
                    successCriteria = SuccessCriteria(100),
                    numSoldTickets = 200,
                    coverImageUrl = "",
                    progressText = "100%",
                    progress = 100
                )
            ),
        )
}