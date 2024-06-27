package com.damda.vocabulary.core

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font
import com.damda.vocabulary.networks.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

actual class FontLoader {
    private val apiClient = ApiClient()
    actual suspend fun loadFont(resource: String): FontFamily {
        val byteArray = apiClient.loadByteArray(resource)
        val font = Font(identity = resource, data = byteArray)
        return FontFamily(font)
    }
}