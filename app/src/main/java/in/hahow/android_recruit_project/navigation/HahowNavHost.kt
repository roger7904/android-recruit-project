package `in`.hahow.android_recruit_project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import `in`.hahow.android_recruit_project.ui.home.navigation.homeRoute
import `in`.hahow.android_recruit_project.ui.home.navigation.homeScreen

@Composable
fun HahowNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = homeRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeScreen()
    }
}
