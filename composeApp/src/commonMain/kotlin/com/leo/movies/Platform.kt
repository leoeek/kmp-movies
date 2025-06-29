package com.leo.movies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform