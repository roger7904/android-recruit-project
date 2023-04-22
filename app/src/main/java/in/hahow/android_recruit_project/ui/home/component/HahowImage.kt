package `in`.hahow.android_recruit_project.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.skydoves.landscapist.glide.GlideImage

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
        }
    )
}