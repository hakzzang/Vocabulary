package com.damda.vocabulary.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.damda.vocabulary.core.ImageResourceLoader
import com.damda.vocabulary.themes.LocalEmojiFontFamily
import com.damda.vocabulary.themes.LocalRegularFontFamily
import com.damda.vocabulary.ui.views.cards.GreetingCardSection

@Composable
fun HomeScreen(imageResourceLoader: ImageResourceLoader) {
    GreetingCardSection(imageResourceLoader)
}