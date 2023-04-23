package `in`.hahow.android_recruit_project.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import `in`.hahow.android_recruit_project.navigation.HahowNavHost
import `in`.hahow.android_recruit_project.ui.theme.HahowTheme

@AndroidEntryPoint
class HahowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HahowTheme {
                HahowNavHost()
            }
        }
    }
}