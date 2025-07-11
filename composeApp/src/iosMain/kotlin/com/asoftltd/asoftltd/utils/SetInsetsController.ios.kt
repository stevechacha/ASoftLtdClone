package com.asoftltd.asoftltd.utils

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

@Composable
actual fun setInsetsController(isDark: Boolean) {
}

@Composable
actual fun getNavigationBarPadding(): PaddingValues {
    return PaddingValues(bottom = 10.dp)
}

@Composable
actual fun getStatusBarPadding(): PaddingValues {
    return PaddingValues(top = 32.dp)
}