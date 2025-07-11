package com.asoftltd.asoftltd.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.asoftltd.asoftltd.utils.setInsetsController


private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1A1D25),
    onPrimary = Color.White,
    secondary = Color(0xFF2C2F38),
    onSecondary = Color.White,
    background = Color(0xFF10131A),
    onBackground = Color.White,
    surface = Color(0xFF10131A),
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1A1D25),
    onPrimary = Color.White,
    secondary = Color(0xFF2C2F38),
    onSecondary = Color.White,
    background = Color(0xFF10131A),
    onBackground = Color.White,
    surface = Color(0xFF10131A),
)

@Composable
fun AsoftTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = remember(darkTheme) {
        if (darkTheme) DarkColorScheme else LightColorScheme
    }
    setInsetsController(darkTheme)
    MaterialTheme(
        colorScheme = colorScheme,
        typography = AsoftTypography,
        content = content
    )
}