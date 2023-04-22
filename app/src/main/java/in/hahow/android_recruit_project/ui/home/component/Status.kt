package `in`.hahow.android_recruit_project.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Status(
    modifier: Modifier,
    content: String,
    backgroundColor: Color,
    textColor: Color,
    cornerSize: Dp
) {

    Text(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = cornerSize, bottomEnd = cornerSize))
            .background(backgroundColor)
            .padding(horizontal = 10.dp, vertical = 5.dp),
        text = content,
        color = textColor,
        style = MaterialTheme.typography.bodySmall
    )
}