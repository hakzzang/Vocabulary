package com.damda.design_system

actual fun getPlatform(): Platform {
    return object : Platform {
        override val name: String
            get() = "Js Platform"
    }
}