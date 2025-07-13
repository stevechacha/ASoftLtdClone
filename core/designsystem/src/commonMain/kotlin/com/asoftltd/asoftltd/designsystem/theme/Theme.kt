package com.asoftltd.asoftltd.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import com.asoftltd.asoftltd.setInsetsController


private val localColorScheme = staticCompositionLocalOf { LightColors }
private val localTypography = staticCompositionLocalOf { AppTypography() }



@Composable
fun AsoftTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    themeMode: ThemeMode = ThemeMode.System,
    content: @Composable () -> Unit
) {

    val colors = when (themeMode) {
        ThemeMode.Light -> LightColors
        ThemeMode.Dark -> DarkColors
        ThemeMode.System -> if (darkTheme) DarkColors else LightColors
    }

    val typography = remember { AppTypography() }


    CompositionLocalProvider(
        localColorScheme provides colors,
        localTypography provides typography,
    ) {
        setInsetsController(darkTheme)
        content()
    }
}

object AsTheme {
    val colors: AsoftColor
        @Composable
        get() = localColorScheme.current

    val typography: AppTypography
        @Composable
        get() = localTypography.current
}

enum class ThemeMode {
    Light,
    Dark,
    System
}

