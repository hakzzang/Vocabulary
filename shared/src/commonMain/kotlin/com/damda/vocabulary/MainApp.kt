package com.damda.vocabulary

import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily
import com.damda.vocabulary.core.FontLoader
import com.damda.vocabulary.core.ImageResourceLoader
import com.damda.vocabulary.themes.LocalEmojiFontFamily
import com.damda.vocabulary.themes.LocalRegularFontFamily
import com.damda.vocabulary.themes.VocabularyTheme
import com.damda.vocabulary.ui.views.MainViewModel
import com.damda.vocabulary.ui.views.navigations.NavigationHost

@Composable
fun MainApp(
    imageResourceLoader: ImageResourceLoader,
    fontLoader: FontLoader,
    mainViewModel: MainViewModel = MainViewModel()
) {
    val screenState by mainViewModel.screen.collectAsState()
    val windowSize = rememberWindowSize()
    var regularFontFamily by remember { mutableStateOf<FontFamily?>(null) }
    var emojiFontFamily by remember { mutableStateOf<FontFamily?>(null) }

    LaunchedEffect(Unit) {
        val regularFont = fontLoader.loadFont("noto_variablefont.ttf")
        val emojiFont = fontLoader.loadFont("noto_coloremoji.ttf")
        regularFontFamily = regularFont
        emojiFontFamily = emojiFont
    }

    if (regularFontFamily != null && emojiFontFamily != null) {
        VocabularyTheme {
            CompositionLocalProvider(
                LocalRegularFontFamily provides regularFontFamily!!,
                LocalEmojiFontFamily provides emojiFontFamily!!
            ) {
                NavigationHost(
                    windowSize = windowSize,
                    screenState = screenState,
                    onScreenSelected = { mainViewModel.navigateTo(it) },
                    imageResourceLoader = imageResourceLoader)
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