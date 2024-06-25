package com.damda.design_system

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform