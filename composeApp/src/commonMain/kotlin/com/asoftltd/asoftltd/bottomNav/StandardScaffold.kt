package com.asoftltd.asoftltd.bottomNav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.asoftltd.asoftltd.designsystem.theme.AsTheme

val bottomColor = Color(0xFF1A1D25)
@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination: NavDestination? = navBackStackEntry?.destination

    val showBottomBar = bottomNavigationRoutes.map { it.route::class }.any { route ->
        currentDestination?.hierarchy?.any { it.hasRoute(route) } == true
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = AsTheme.colors.background,
                ) {
                    bottomNavigationRoutes.forEachIndexed { i, bottomNavItem ->
                        val isSelected =
                            currentDestination?.hierarchy?.any { it.hasRoute(bottomNavItem.route::class) } == true
                        StandardBottomNavItem(
                            icon = bottomNavItem.icon,
                            title = bottomNavItem.name,
                            contentDescription = bottomNavItem.contentDescription,
                            selected = isSelected,
                            enabled = bottomNavItem.icon != null
                        ) {
                            if (currentDestination !=null) {
                                navController.navigate(bottomNavItem.route) {
                                    launchSingleTop = false
                                    restoreState = true
                                    popUpTo(navController.graph.findStartDestination())
                                }
                            }

                        }
                    }
                }
            }
        },
        modifier = modifier
    ) {
        content(it)
    }
}