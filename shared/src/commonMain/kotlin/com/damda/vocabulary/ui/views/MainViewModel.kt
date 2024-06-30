package com.damda.vocabulary.ui.views

import androidx.compose.material3.SnackbarHostState
import com.damda.vocabulary.ui.Screen
import com.damda.vocabulary.ui.ScreenState
import com.damda.vocabulary.ui.state.AlertState
import com.damda.vocabulary.ui.state.SnackbarState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel {
    private val _screen = MutableStateFlow(ScreenState())
    val screen: StateFlow<ScreenState> = _screen

    private val _alertState = MutableStateFlow<AlertState?>(null)
    val alertState: StateFlow<AlertState?> = _alertState

    val snackbarHostState = SnackbarHostState()

    fun navigateTo(screen: Screen) {
        _screen.value = if (screen is Screen.DetailSelectLanguage) {
            _screen.value.copy(currentScreen = screen, selectedLanguage = screen.language)
        } else {
            _screen.value.copy(currentScreen = screen)
        }
    }

    fun showAlertDialog(alertState: AlertState) {
        _alertState.value = alertState
    }

    suspend fun showSnackbar(snackbarState: SnackbarState) {
        snackbarHostState.showSnackbar(snackbarState.title)
    }

    fun dismissAlertDialog() {
        _alertState.value?.onDismiss?.invoke()
        _alertState.value = null
    }
}