package com.asoftltd.asoftltd.forgot_password

import androidx.compose.runtime.Composable
import com.asoftltd.asoftltd.designsystem.components.AsButton
import com.asoftltd.asoftltd.designsystem.components.AsOutlinedTextField


@Composable
fun ForgotPasswordScreen(
    onForgotPasswordSuccess: () -> Unit,
    onLoginClick: () -> Unit,
) {
    ForgotPasswordContent(
        onForgotPasswordSuccess = onForgotPasswordSuccess,
        onLoginClick = onLoginClick,
    )
}

@Composable
fun ForgotPasswordContent(
    onForgotPasswordSuccess: () -> Unit,
    onLoginClick: () -> Unit,
) {
    AsOutlinedTextField(
        value = "",
        onValueChange = {},
        label = "Email",
        isError = false
    )

    AsButton(
        text = "Reset Password",
        onClick = onForgotPasswordSuccess,

    )
}