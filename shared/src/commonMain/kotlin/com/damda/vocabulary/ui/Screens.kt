package com.damda.vocabulary.ui

sealed class Screen {
    data object Home : Screen()
    data class DetailSelectLanguage(val language: String) : Screen()
    data object Search : Screen()
    data object Profile : Screen()
}

data class ScreenState(
    val currentScreen: Screen = Screen.Home,
    val selectedLanguage: String = ""
)