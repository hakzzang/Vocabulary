package com.damda.design_system.core

import androidx.compose.ui.graphics.ImageBitmap

expect class ImageResourceLoader {
    suspend fun loadImageResource(name: String): ImageBitmap?
}