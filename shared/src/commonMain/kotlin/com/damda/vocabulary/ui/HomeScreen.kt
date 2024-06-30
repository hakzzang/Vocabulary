package com.damda.vocabulary.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.damda.vocabulary.core.ImageResourceLoader
import com.damda.vocabulary.ui.home.LanguageSelectionList
import com.damda.vocabulary.ui.views.EmojiText
import com.damda.vocabulary.ui.views.cards.GreetingCardSection

@Composable
fun HomeScreen(
    imageResourceLoader: ImageResourceLoader
) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp).verticalScroll(scrollState)) {
        Spacer(Modifier.height(24.dp))
        GreetingCardSection(imageResourceLoader)
        Spacer(Modifier.height(24.dp))
        EmojiText("Select Language to Study \uD83E\uDD13", color = Color.Black)
        Spacer(Modifier.height(16.dp))
        LanguageSelectionList(imageResourceLoader)
    }
}