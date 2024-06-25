package com.damda.vocabulary.core

import androidx.compose.ui.graphics.ImageBitmap

expect class ImageResourceLoader {
    suspend fun loadImageResource(name: String): ImageBitmap?
}