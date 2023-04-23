package `in`.hahow.android_recruit_project.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import `in`.hahow.android_recruit_project.R
import `in`.hahow.android_recruit_project.ui.theme.HahowTheme
import `in`.hahow.android_recruit_project.ui.theme.Incubating

@Composable
fun CourseItem(
    modifier: Modifier = Modifier,
    title: String,
    imageUrl: String,
    statusString: String,
    statusBackgroundColor: Color,
    progressString: String,
    progressBackgroundColor: Color,
    progress: Int,
    countDown: Long? = null,
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(0.3f)
                .aspectRatio(1.6f)
                .clip(RoundedCornerShape(10.dp)),
        ) {
            HahowImage(imageUrl = imageUrl)
            Status(
                modifier = Modifier.align(Alignment.BottomEnd),
                content = statusString,
                backgroundColor = statusBackgroundColor,
                textColor = MaterialTheme.colorScheme.background,
                cornerSize = 10.dp
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.7f)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(horizontal = 10.dp),
                text = title,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            ProgressBar(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(horizontal = 10.dp),
                title = progressString,
                progress = progress,
                progressColor = progressBackgroundColor
            )
            countDown?.let {
                IconWithText(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(horizontal = 10.dp),
                    iconRes = R.drawable.icon_count_down,
                    text = stringResource(
                        R.string.days_remain,
                        countDown,
                    ),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCourseItem() {
    HahowTheme {
        CourseItem(
            title = "Sample Course",
            imageUrl = "",
            statusString = "募資中",
            statusBackgroundColor = Incubating,
            progressString = "10/20人",
            progressBackgroundColor = Incubating,
            progress = 50,
            countDown = 7
        )
    }
}