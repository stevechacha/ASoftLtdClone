package com.asoftltd.asoftltd.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.asoftltd.asoftltd.Destination
import androidx.navigation.compose.composable
import com.asoftltd.asoftltd.dashboard.DashboardScreen
import com.asoftltd.asoftltd.NavigationGraph


fun NavGraphBuilder.appNavigation(
    onNavigate: (Destination, Boolean) -> Unit,
    onNavigateBack: (Destination) -> Unit,
    onGoBack: () -> Unit,
) {
    navigation<NavigationGraph.App>(startDestination = Destination.App.DashBoard) {
        composable<Destination.App.DashBoard> {
            DashboardScreen()
        }
    }
}