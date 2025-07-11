package com.asoftltd.asoftltd.utils

import androidx.navigation.NavHostController
import kotlinx.serialization.Serializable


sealed interface NavigationGraph {
    @Serializable data object Loading : NavigationGraph
    @Serializable data object Auth : NavigationGraph
    @Serializable data object App : NavigationGraph
    @Serializable data object Welcome : NavigationGraph

}


sealed interface Destination {
    @Serializable data object Loading : Destination
    @Serializable data object Welcome : Destination

    @Serializable
    data object Auth : Destination {
        @Serializable data object Welcome: Destination
        @Serializable data object Login: Destination
        @Serializable data object Registration: Destination
        @Serializable data object PickLanguage: Destination
        @Serializable data object ForgotPassword: Destination
    }

    @Serializable data object Security : Destination {
        @Serializable data object Security : Destination
        @Serializable data object SecurityConfirmed : Destination
        @Serializable data object PIN : Destination
        @Serializable data object UnLock : Destination
        @Serializable data object BiometricSetUp : Destination
        @Serializable data object CorruptedSecurity : Destination
    }

    @Serializable
    data object App : Destination {
        @Serializable data object DashBoard : Destination {
            @Serializable data object Home : Destination
            @Serializable data object Admission : Destination
            @Serializable data object Academics : Destination
            @Serializable data object Finance : Destination
            @Serializable data object More : Destination
        }
    }


}



fun NavHostController.onNavigate(destination: Destination, finish: Boolean = false) {
    navigate(destination) {
        if (finish) {
            launchSingleTop = true
            popUpTo(0) { inclusive = true }
        }
    }
}

fun NavHostController.onNavigateBack(destination: Destination) {
    popBackStack(destination, inclusive = false)
}

fun NavHostController.onNavigateGraph(graph: NavigationGraph, finish: Boolean = false) {
    navigate(graph) {
        if (finish) {
            launchSingleTop = true
            popUpTo(0) { inclusive = true }
        }
    }
}

fun NavHostController.onGoBack() {
    popBackStack()
}