package com.asoftltd.asoftltd.dashboard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.asoftltd.asoftltd.bottomNav.StandardScaffold
import com.asoftltd.asoftltd.screens.AcademicsScreen
import com.asoftltd.asoftltd.screens.AdmissionScreen
import com.asoftltd.asoftltd.screens.FinanceScreen
import com.asoftltd.asoftltd.screens.HomeScreen
import com.asoftltd.asoftltd.screens.MoreScreen
import com.asoftltd.asoftltd.utils.Destination

@Composable
fun DashboardScreen() {
    val navigator = rememberNavController()

    StandardScaffold(
        navController = navigator,
        modifier = Modifier.fillMaxSize(),
    ) {
        NavHost(navigator, startDestination = Destination.App.DashBoard.Home) {
            composable<Destination.App.DashBoard.Home> {
                HomeScreen()
            }
            composable<Destination.App.DashBoard.Admission> {
                AdmissionScreen()

            }

            composable<Destination.App.DashBoard.Academics> {
                AcademicsScreen()

            }

            composable<Destination.App.DashBoard.Finance> {
                FinanceScreen()
            }

            composable<Destination.App.DashBoard.More> {
                MoreScreen()
            }
        }
    }
}