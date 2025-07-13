package com.asoftltd.asoftltd.app

import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview

import com.asoftltd.asoftltd.navigation.RootGraph
import com.asoftltd.asoftltd.designsystem.theme.AsoftTheme

@Composable
@Preview
fun App() {
    AsoftTheme {
        val navHostController = rememberNavController()
        RootGraph(navHostController)
    }
}