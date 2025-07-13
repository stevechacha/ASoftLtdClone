package com.asoftltd.asoftltd

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

fun randomColor(): Color {
    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)
    return Color(red, green, blue)
}

fun getInitials(name: String): String {
    val names = name.split(" ")
    val initials = if (names.size >= 2) {
        names[0].trim().first().toString().trim() + names[1].trim().first().toString().trim()
    } else {
        names[0].trim().first().toString().trim()
    }
    return initials.uppercase()
}