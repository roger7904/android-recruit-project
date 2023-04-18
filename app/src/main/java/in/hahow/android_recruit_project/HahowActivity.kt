package `in`.hahow.android_recruit_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import `in`.hahow.android_recruit_project.ui.HahowNavGraph
import `in`.hahow.android_recruit_project.ui.theme.HahowTheme

class HahowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HahowTheme {
                HahowNavGraph()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HahowTheme {
        Greeting("Android")
    }
}