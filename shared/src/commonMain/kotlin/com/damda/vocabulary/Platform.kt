package com.damda.vocabulary

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform