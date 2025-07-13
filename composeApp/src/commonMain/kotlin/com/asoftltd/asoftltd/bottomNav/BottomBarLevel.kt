package com.asoftltd.asoftltd.bottomNav

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarms
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import com.asoftltd.asoftltd.Destination

data class BottomLevelRoute<T : Any>(
    val name: String,
    val route: T,
    val icon: ImageVector?,
    val contentDescription: String = "Bottom Navigation Icon for $name"
)

val bottomNavigationRoutes = listOf(
    BottomLevelRoute("Home", Destination.App.DashBoard.Home, Icons.Default.Home),
    BottomLevelRoute("Admission", Destination.App.DashBoard.Admission, Icons.Default.CalendarMonth),
    BottomLevelRoute("Academics", Destination.App.DashBoard.Academics, Icons.Default.AccessAlarms),
    BottomLevelRoute("Finance", Destination.App.DashBoard.Finance, Icons.Default.Calculate),
    BottomLevelRoute("More", Destination.App.DashBoard.More, Icons.Default.Apps)
)