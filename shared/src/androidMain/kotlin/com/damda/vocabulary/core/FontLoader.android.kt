package com.damda.vocabulary.core

import android.content.Context
import android.content.res.AssetFileDescriptor
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

actual class FontLoader(private val context: Context) {
    actual suspend fun loadFont(resource: String): FontFamily {
        return withContext(Dispatchers.IO) {

            return@withContext FontFamily(
                Font(
                    assetManager = context.assets,
                    path = resource,
                    weight = FontWeight.Normal
                )
            )
        }
    }
}