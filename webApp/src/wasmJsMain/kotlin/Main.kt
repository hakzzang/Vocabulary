package com.damda.webapp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.damda.vocabulary.MainApp
import com.damda.vocabulary.core.FontLoader
import com.damda.vocabulary.core.ImageResourceLoader

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        MainApp(ImageResourceLoader(), FontLoader())
    }
}