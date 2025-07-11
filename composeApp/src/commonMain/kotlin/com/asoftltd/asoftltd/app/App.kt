package com.asoftltd.asoftltd.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import asoftltdclone.composeapp.generated.resources.Res
import asoftltdclone.composeapp.generated.resources.academia
import asoftltdclone.composeapp.generated.resources.badge
import asoftltdclone.composeapp.generated.resources.compose_multiplatform
import asoftltdclone.composeapp.generated.resources.graphvector
import asoftltdclone.composeapp.generated.resources.license
import asoftltdclone.composeapp.generated.resources.user_check
import asoftltdclone.composeapp.generated.resources.user_remove
import asoftltdclone.composeapp.generated.resources.user_story
import com.asoftltd.asoftltd.Greeting
import com.asoftltd.asoftltd.navigation.RootGraph
import com.asoftltd.asoftltd.theme.AsoftTheme

@Composable
@Preview
fun App() {
    AsoftTheme {
        val navHostController = rememberNavController()
        RootGraph(navHostController)
    }
}