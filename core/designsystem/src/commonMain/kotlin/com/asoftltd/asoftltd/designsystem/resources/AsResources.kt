package com.asoftltd.asoftltd.designsystem.resources

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.asoftltd.asoftltd.designsystem.theme.AsTypography
import com.asoftltd.asoftltd.designsystem.theme.AsoftColor
import com.asoftltd.asoftltd.designsystem.theme.AsoftTheme


private val LocalAsColors = AsoftColor()
private val localAsTypography = AsTypography

@Composable
fun AsTheme(
    content: @Composable () -> Unit
) {
    val topography = AsTypography

    CompositionLocalProvider(

    ){
        AsoftTheme(
            content = content,
            darkTheme = false
        )
    }

}