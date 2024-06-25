package com.damda.vocabulary.core

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import kotlinx.browser.window
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.await
import kotlinx.coroutines.withContext
import org.jetbrains.skia.Image
import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Uint8Array
import org.khronos.webgl.get
import org.w3c.fetch.Response
import kotlin.js.Promise

actual class ImageResourceLoader {
    actual suspend fun loadImageResource(name: String): ImageBitmap? {
        return withContext(Dispatchers.Default) {
            val response:Response = window.fetch(name).await()
            val byteArray = response.arrayBuffer().await<ArrayBuffer>().toByteArray()
            val image = Image.makeFromEncoded(byteArray)

            return@withContext image.toComposeImageBitmap()
        }

    }

    private fun ArrayBuffer.toByteArray(): ByteArray {
        val uint8Array = Uint8Array(this)
        return ByteArray(uint8Array.length) { uint8Array[it] }
    }
}