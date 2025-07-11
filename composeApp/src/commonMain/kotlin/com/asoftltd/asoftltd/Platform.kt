package com.asoftltd.asoftltd

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform