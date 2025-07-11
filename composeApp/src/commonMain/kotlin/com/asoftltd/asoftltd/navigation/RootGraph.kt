package com.asoftltd.asoftltd.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.asoftltd.asoftltd.utils.NavigationGraph
import com.asoftltd.asoftltd.utils.onGoBack
import com.asoftltd.asoftltd.utils.onNavigate
import com.asoftltd.asoftltd.utils.onNavigateBack

@Composable
fun RootGraph(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = NavigationGraph.App
    ) {
        appNavigation(
            onNavigate = navHostController::onNavigate,
            onNavigateBack = navHostController::onNavigateBack,
            onGoBack = navHostController::onGoBack,
        )

    }
}
