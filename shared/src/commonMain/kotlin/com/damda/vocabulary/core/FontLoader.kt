package com.damda.vocabulary.core

import androidx.compose.ui.text.font.FontFamily

expect class FontLoader {
    suspend fun loadFont(resource: String): FontFamily
}