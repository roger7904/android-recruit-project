package `in`.hahow.android_recruit_project.ui

import androidx.navigation.NavHostController
import `in`.hahow.android_recruit_project.ui.HahowScreens.HOME_SCREEN

/**
 * Screens used in [HahowDestinations]
 */
private object HahowScreens {
    const val HOME_SCREEN = "home"
}

/**
 * Arguments used in [HahowDestinations] routes
 */
object HahowDestinationsArgs {}

/**
 * Destinations used in the [HahowActivity]
 */
object HahowDestinations {
    const val HOME_ROUTE = HOME_SCREEN
}

/**
 * Models the navigation actions in the app.
 */
class HahowNavigationActions(private val navController: NavHostController) {

    fun navigateToHome() {
        navController.navigate(HahowDestinations.HOME_ROUTE)
    }
}
