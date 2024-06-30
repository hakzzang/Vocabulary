package com.damda.vocabulary.ui

import androidx.compose.foundation.ScrollState
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
import com.damda.vocabulary.ui.home.SelectionList
import com.damda.vocabulary.ui.views.EmojiText
import com.damda.vocabulary.ui.views.views.SelectButton

@Composable
fun DetailSelectLanguageScreen(
    screenState: ScreenState,
    imageResourceLoader: ImageResourceLoader,
    onScreen: (Screen) -> Unit,
    scrollState: ScrollState = rememberScrollState()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp).verticalScroll(scrollState)
    ) {
        Spacer(Modifier.height(24.dp))
        EmojiText(
            text = "Select the level you want to learn for ${screenState.selectedLanguage} \uD83E\uDD13",
            color = Color.Black
        )
        Spacer(Modifier.height(24.dp))
        SelectionList(
            selections = listOf("Beginner", "Intermediate", "Advanced"),
            imageResourceLoader = imageResourceLoader,
            onSelectedItem = { level ->
                screenState.level = Level.fromDisplayName(level)
            },
            enableSelection = true
        )
        Spacer(Modifier.height(24.dp))
        SelectButton(title = "DONE", onClick = {
            onScreen(Screen.Home)
        })
    }
}

enum class Level(val displayName: String) {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");

    companion object {
        fun fromDisplayName(displayName: String): Level {
            return entries.find { it.displayName == displayName } ?: BEGINNER
        }
    }

}