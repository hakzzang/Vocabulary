package com.damda.webapp

import androidx.compose.ui.ExperimentalComposeUiApi
import com.damda.design_system.NativeMainApp
import com.damda.design_system.core.ImageResourceLoader
import com.damda.webapp.views.screens.MainWebScreen
import org.jetbrains.compose.web.renderComposableInBody

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    renderComposableInBody {
        MainWebScreen()
    }
}