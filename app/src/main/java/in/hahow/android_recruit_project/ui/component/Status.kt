package `in`.hahow.android_recruit_project.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import `in`.hahow.android_recruit_project.ui.theme.HahowTheme

@Composable
fun Status(
    modifier: Modifier = Modifier,
    content: String,
    backgroundColor: Color,
    textColor: Color,
    cornerSize: Dp
) {
    Text(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = cornerSize, bottomEnd = cornerSize))
            .background(backgroundColor)
            .padding(horizontal = 5.dp, vertical = 3.dp),
        text = content,
        color = textColor,
        style = MaterialTheme.typography.bodySmall
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun StatusPreview() {
    HahowTheme {
        Status(
            content = "Preview Status",
            backgroundColor = Color(0xFFF2AA63),
            textColor = MaterialTheme.colorScheme.background,
            cornerSize = 10.dp
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun StatusPreviewDark() {
    HahowTheme {
        Status(
            content = "Preview Status",
            backgroundColor = Color(0xFFF2AA63),
            textColor = MaterialTheme.colorScheme.background,
            cornerSize = 10.dp
        )
    }
}