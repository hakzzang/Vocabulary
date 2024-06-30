package com.damda.webapp

import androidx.compose.ui.ExperimentalComposeUiApi
import com.damda.webapp.views.screens.MainWebScreen
import org.jetbrains.compose.web.renderComposableInBody

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    renderComposableInBody {
        MainWebScreen()
    }
}