package com.damda.design_system.core

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.skia.Image
import java.io.InputStream

actual class ImageResourceLoader {
    actual suspend fun loadImageResource(name: String): ImageBitmap? {
        return withContext(Dispatchers.IO) {
            val inputStream: InputStream = object {}.javaClass.classLoader.getResourceAsStream("commonMain/resources/"+name)!!
            val image = inputStream!!.readBytes()?.let { Image.makeFromEncoded(it) }
            return@withContext image?.toComposeImageBitmap()
        }
    }
}