package com.asoftltd.asoftltd

import androidx.compose.runtime.Composable

expect class PlatformContext

@Composable
expect fun getPlatformContext(): PlatformContext