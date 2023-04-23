package `in`.hahow.android_recruit_project.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.skydoves.landscapist.glide.GlideImage
import `in`.hahow.android_recruit_project.R

@Composable
fun HahowImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
) {
    GlideImage(
        imageModel = { imageUrl },
        loading = {
            Box(
                modifier = modifier.background(
                    brush = Brush.linearGradient(
                        listOf(Color.Gray, Color.White)
                    )
                )
            )
        },
        failure = {
            Text(text = "image request failed.")
        },
        previewPlaceholder = R.drawable.ic_launcher_background
    )
}