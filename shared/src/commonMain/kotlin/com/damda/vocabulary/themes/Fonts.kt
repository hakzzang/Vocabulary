package com.damda.vocabulary.themes

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.FontFamily

val LocalRegularFontFamily = staticCompositionLocalOf<FontFamily> {
    error("Regular FontFamily not provided")
}

val LocalEmojiFontFamily = staticCompositionLocalOf<FontFamily> {
    error("Emoji FontFamily not provided")
}