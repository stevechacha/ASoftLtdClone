package com.asoftltd.asoftltd.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class AsoftColor(
    val primary: Color = Color(0xFF6200EE),
    val onPrimary: Color = Color.White,
    val secondary: Color = Color(0xFF03DAC5),
    val onSecondary: Color = Color.Black,
    val background: Color = Color(0xFFF5F5F5),
    val onBackground: Color = Color.Black,
    val surface: Color = Color.White,
    val onSurface: Color = Color.Black,
    val error: Color = Color(0xFFB00020),
    val onError: Color = Color.White
)

val LightColors = AsoftColor(
    primary = Color(0xFF6200EE),
    onPrimary = Color.White,
    secondary = Color(0xFFFFF176),
    onSecondary = Color.Black,
    background = Color(0xFFF5F5F5),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color(0xFFB00020),
    onError = Color.White
)


val DarkColors = AsoftColor(
    primary = Color(0xFFBB86FC),
    onPrimary = Color.Black,
    secondary = Color(0xFFFFFFF),
    onSecondary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF121212),
    onSurface = Color.White,
    error = Color(0xFFCF6679),
    onError = Color.Black
)

