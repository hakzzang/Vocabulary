package com.damda.design_system.core

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

actual class ImageResourceLoader (private val context: Context){
    actual suspend fun loadImageResource(name: String): ImageBitmap? {
        return withContext(Dispatchers.IO) {
            val inputStream = context.assets.open(name)
            val bitmap = BitmapFactory.decodeStream(inputStream)

            return@withContext bitmap.asImageBitmap()
        }
    }
}