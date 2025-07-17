package com.asoftltd.asoftltd.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.asoftltd.asoftltd.designsystem.components.AsButton
import com.asoftltd.asoftltd.designsystem.components.AsOutlinedTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Login") },
                actions = {
                    TextButton(onClick = onRegisterClick) {
                        Text("Register")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center
        ) {

            AsOutlinedTextField(
                value = "",
                onValueChange = {},
                label = "Email",
                modifier = Modifier.padding(horizontal = 16.dp),
                isError = false
            )

            AsOutlinedTextField(
                value = "",
                onValueChange = {},
                label = "Password",
                modifier = Modifier.padding(horizontal = 16.dp),
                isError = false
            )

            AsButton(
                text = "Login",
                onClick = onLoginSuccess,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)

            )
        }
    }
}

