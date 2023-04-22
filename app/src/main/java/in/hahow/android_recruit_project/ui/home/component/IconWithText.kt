package `in`.hahow.android_recruit_project.ui.home.component

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import `in`.hahow.android_recruit_project.R

@Composable
fun IconWithText(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
    iconColor: Color = MaterialTheme.colorScheme.tertiary,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.tertiary,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = iconColor
        )
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Composable
fun IconWithTextPreview() {
    MaterialTheme {
        IconWithText(
            iconRes = R.drawable.icon_count_down,
            text = "Home",
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun IconWithTextPreviewDark() {
    MaterialTheme {
        IconWithText(
            iconRes = R.drawable.icon_count_down,
            text = "Home",
        )
    }
}