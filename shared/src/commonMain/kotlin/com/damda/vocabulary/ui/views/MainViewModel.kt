package com.damda.vocabulary.ui.views

import com.damda.vocabulary.ui.Screen
import com.damda.vocabulary.ui.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel {
    private val _screen = MutableStateFlow(ScreenState())
    val screen: StateFlow<ScreenState> = _screen

    fun navigateTo(screen: Screen) {
        _screen.value = if (screen is Screen.DetailSelectLanguage) {
            _screen.value.copy(currentScreen = screen, selectedLanguage = screen.language)
        } else {
            _screen.value.copy(currentScreen = screen)
        }
    }
}