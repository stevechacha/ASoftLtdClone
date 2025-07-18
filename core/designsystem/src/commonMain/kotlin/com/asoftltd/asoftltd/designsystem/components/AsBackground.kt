package com.asoftltd.asoftltd.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.asoftltd.asoftltd.designsystem.theme.AsTheme
import com.asoftltd.asoftltd.getStatusBarPadding

@Composable
fun AsBackground(
    modifier: Modifier = Modifier,
    topAppBar : @Composable (() -> Unit) = { },
    bottomBar : @Composable (() -> Unit) = { },
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = topAppBar,
        bottomBar = bottomBar,
        containerColor = AsTheme.colors.background,
        contentColor = AsTheme.colors.onBackground
    ) { paddingValues ->
        Box(
            modifier = modifier
                .padding(paddingValues)
                .background(AsTheme.colors.background)
        ) {
            content()
        }
    }
}
