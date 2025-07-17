package com.asoftltd.asoftltd.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.asoftltd.asoftltd.NavigationGraph
import com.asoftltd.asoftltd.onGoBack
import com.asoftltd.asoftltd.onNavigate
import com.asoftltd.asoftltd.onNavigateBack

@Composable
fun RootGraph(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = NavigationGraph.App
    ) {
        authNavigation(
            onNavigate = navHostController::onNavigate,
            onNavigateBack = navHostController::onNavigateBack,
            onGoBack = navHostController::onGoBack,
        )
        appNavigation(
            onNavigate = navHostController::onNavigate,
            onNavigateBack = navHostController::onNavigateBack,
            onGoBack = navHostController::onGoBack,
        )

    }
}
