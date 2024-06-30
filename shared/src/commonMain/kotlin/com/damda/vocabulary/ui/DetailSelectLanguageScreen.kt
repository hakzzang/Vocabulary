package com.damda.vocabulary.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.damda.vocabulary.ui.views.EmojiText
import com.damda.vocabulary.ui.views.RegularText

@Composable
fun DetailSelectLanguageScreen(
    screenState: ScreenState,
    scrollState: ScrollState = rememberScrollState()
) {
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp).verticalScroll(scrollState)) {
        Spacer(Modifier.height(24.dp))
        EmojiText(text = "Selected Language to Study \uD83E\uDD13 ${screenState.selectedLanguage}", color = Color.Black)
    }
}