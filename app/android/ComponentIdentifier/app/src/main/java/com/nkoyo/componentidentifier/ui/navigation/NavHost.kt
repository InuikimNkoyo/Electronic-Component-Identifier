package com.nkoyo.componentidentifier.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.nkoyo.componentidentifier.ui.screens.history.HistoryDetailsScreen
import com.nkoyo.componentidentifier.ui.screens.history.HistoryScreen
import com.nkoyo.componentidentifier.ui.screens.main.MainPreviewScreen
import com.nkoyo.componentidentifier.ui.screens.main.MainScreen
import com.nkoyo.componentidentifier.ui.screens.web.WebInfoScreen
import com.nkoyo.componentidentifier.ui.viewmodel.MainViewModel

/**
 * The Composable that handles the navigation and routing through
 * all the destinations in the app
 */

@RequiresApi(Build.VERSION_CODES.R)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun NavHostWrapper(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowSizeClass,
    navController: NavHostController,
    onAbortApplication: () -> Unit,
    mainViewModel: MainViewModel = hiltViewModel<MainViewModel>(),
    startDestination: String = Route.MainScreen
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(Route.MainScreen) {
            MainScreen(
                windowSizeClass = windowSizeClass,
                onAbortApplication = onAbortApplication,
                onViewRecords = { navController.navigate(Route.HistoryScreen) },
                onPreviewWebInfo = { navController.navigate(Route.WebInfoScreen) },
                mainViewModel = mainViewModel,
            )
        }

        composable(Route.HistoryScreen) {
            HistoryScreen(
                mainViewModel = mainViewModel,
                windowSizeClass = windowSizeClass,
                onBackPressed = { navController.navigate(Route.MainScreen) },
                onStartSearch = {},
                onHistoryDetails = { navController.navigate(Route.HistoryDetailScreen) }
            )
        }

        composable(
            route = Route.HistoryDetailScreen,
        ) {
            HistoryDetailsScreen(
                onBackPressed = { navController.navigate(Route.HistoryScreen) },
                windowSizeClass = windowSizeClass,
                mainViewModel = mainViewModel,
            )
        }

        composable(
            route = Route.WebInfoScreen,
        ) {
            WebInfoScreen(
                onClose = { navController.navigate(Route.MainScreen) },
                mainViewModel = mainViewModel
            )
        }
    }
}


object Route {
    const val MainScreen = "MainScreen"
    const val HistoryScreen = "HistoryScreen"
    const val HistoryDetailScreen = "HistoryDetailScreen"
    const val WebInfoScreen = "WebInfoScreen"
}