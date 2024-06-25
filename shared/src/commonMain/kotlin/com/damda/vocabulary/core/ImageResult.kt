package com.damda.vocabulary.core

import androidx.compose.ui.graphics.ImageBitmap

sealed class ImageResult {
    data class Web(val url: String) : ImageResult()
    data class Native(val image: ImageBitmap) : ImageResult()
    data class Error(val message: String) : ImageResult()
    data object Empty : ImageResult()
}