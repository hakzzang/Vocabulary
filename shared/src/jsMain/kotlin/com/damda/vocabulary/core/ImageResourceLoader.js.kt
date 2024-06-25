package com.damda.vocabulary.core

import androidx.compose.ui.graphics.ImageBitmap
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.Response

actual class ImageResourceLoader {
    actual suspend fun loadImageResource(name: String): ImageBitmap? {
        return null
    }
}