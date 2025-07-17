package com.asoftltd.asoftltd.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.asoftltd.asoftltd.Destination
import com.asoftltd.asoftltd.NavigationGraph
import com.asoftltd.asoftltd.forgot_password.ForgotPasswordScreen
import com.asoftltd.asoftltd.login.LoginScreen


fun NavGraphBuilder.authNavigation(
    onNavigate: (Destination, Boolean) -> Unit,
    onNavigateBack: (Destination) -> Unit,
    onGoBack: () -> Unit,
) {
    navigation<NavigationGraph.Auth>(startDestination = Destination.Auth.Login) {
        composable<Destination.Auth.Login> {
            LoginScreen(
                onLoginSuccess = { onNavigate(Destination.App.DashBoard,true) },
                onRegisterClick = { onNavigate(Destination.Auth.ForgotPassword,false) }
            )
        }

        composable<Destination.Auth.ForgotPassword> {
            ForgotPasswordScreen(
                onForgotPasswordSuccess = { onNavigate(Destination.Auth.Login, true) },
                onLoginClick = { onNavigate(Destination.Auth.Login, true) }
            )
        }
    }
}