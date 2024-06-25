package com.damda.webapp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.damda.design_system.NativeMainApp
import com.damda.design_system.core.ImageResourceLoader

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        NativeMainApp(ImageResourceLoader())
    }
}