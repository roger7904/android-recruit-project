package `in`.hahow.android_recruit_project.ui.home.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import `in`.hahow.android_recruit_project.ui.theme.HahowTheme

@Composable
fun ProgressBar(
    modifier: Modifier = Modifier,
    title: String,
    progress: Int,
    progressColor: Color
) {
    Column(
        modifier = modifier.fillMaxWidth(0.3f),
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.bodySmall
        )
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            progress = progress / 100f,
            color = progressColor
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun ProgressBarPreview() {
    HahowTheme {
        ProgressBar(
            modifier = Modifier.width(100.dp),
            title = "Progress Title",
            progress = 50,
            progressColor = Color(0xFFF2AA63)
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ProgressBarPreviewDark() {
    HahowTheme {
        ProgressBar(
            modifier = Modifier.width(100.dp),
            title = "Progress Title",
            progress = 50,
            progressColor = Color(0xFFF2AA63)
        )
    }
}