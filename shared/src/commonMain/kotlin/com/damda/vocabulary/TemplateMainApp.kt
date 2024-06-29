package com.damda.vocabulary

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.damda.vocabulary.core.FontLoader
import com.damda.vocabulary.core.ImageResourceLoader
import com.damda.vocabulary.themes.Colors
import com.damda.vocabulary.themes.LocalEmojiFontFamily
import com.damda.vocabulary.themes.LocalRegularFontFamily
import com.damda.vocabulary.themes.VocabularyTheme
import com.damda.vocabulary.ui.HomeScreen
import com.damda.vocabulary.ui.ProfileScreen
import com.damda.vocabulary.ui.SearchScreen
import com.damda.vocabulary.ui.views.bottombars.BottomBar
import com.damda.vocabulary.ui.views.bottombars.NavigationRails
import com.damda.vocabulary.ui.views.navigations.NAVIGATION_ITEMS

@Composable
fun NativeMainApp(
    imageResourceLoader: ImageResourceLoader,
    fontLoader: FontLoader
) {
    var regularFontFamily by remember { mutableStateOf<FontFamily?>(null) }
    var emojiFontFamily by remember { mutableStateOf<FontFamily?>(null) }

    LaunchedEffect(Unit) {
        val regularFont = fontLoader.loadFont("noto_variablefont.ttf")
        val emojiFont = fontLoader.loadFont("noto_coloremoji.ttf")
        regularFontFamily = regularFont
        emojiFontFamily = emojiFont
    }

    var selectedItem by remember { mutableStateOf(0) }
    val windowSize = rememberWindowSize()

    if (regularFontFamily != null && emojiFontFamily != null) {
        VocabularyTheme {
            CompositionLocalProvider(
                LocalRegularFontFamily provides regularFontFamily!!,
                LocalEmojiFontFamily provides emojiFontFamily!!
            ) {
                Scaffold(bottomBar = {
                    if (windowSize == WindowWidthSizeClass.Compact) {
                        BottomBar(NAVIGATION_ITEMS, selectedItem) { selectedItem = it }
                    }
                }, modifier = Modifier) { innerPadding ->
                    Row(Modifier.padding(innerPadding)) {
                        if (windowSize == WindowWidthSizeClass.Medium || windowSize == WindowWidthSizeClass.Expanded) {
                            NavigationRails(NAVIGATION_ITEMS, selectedItem) { selectedItem = it }
                        }
                        Box(modifier = Modifier.padding(innerPadding).weight(1f)) {
                            when (selectedItem) {
                                0 -> HomeScreen(imageResourceLoader)
                                1 -> SearchScreen()
                                2 -> ProfileScreen()
                            }
                        }
                    }
                }
            }
        }
    } else {
        Text("Loading...")
    }

}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun rememberWindowSize(): WindowWidthSizeClass {
    // 간단히 화면 너비를 기준으로 WindowSize를 결정
    val windowSize = calculateWindowSizeClass()
    return windowSize.widthSizeClass
}