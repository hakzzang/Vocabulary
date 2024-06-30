package com.damda.vocabulary.ui.views.navigations

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.damda.vocabulary.core.ImageResourceLoader
import com.damda.vocabulary.ui.DetailSelectLanguageScreen
import com.damda.vocabulary.ui.HomeScreen
import com.damda.vocabulary.ui.ProfileScreen
import com.damda.vocabulary.ui.SearchScreen
import com.damda.vocabulary.ui.Screen
import com.damda.vocabulary.ui.ScreenState
import com.damda.vocabulary.ui.state.AlertState
import com.damda.vocabulary.ui.state.SnackbarState
import com.damda.vocabulary.ui.views.bottombars.BottomBar
import com.damda.vocabulary.ui.views.bottombars.NavigationRails

@Composable
fun NavigationHost(
    windowSize: WindowWidthSizeClass,
    screenState: ScreenState,
    snackbarHostState: SnackbarHostState,
    onScreenSelected: (Screen) -> Unit,
    imageResourceLoader: ImageResourceLoader,
    onShowAlertDialog: (AlertState) -> Unit,
    onShowSnackBar: (SnackbarState) -> Unit
) {
    Scaffold(
        modifier = Modifier,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { snackbarData ->
                Snackbar(snackbarData = snackbarData)
            }
        },
        bottomBar = {
            if (windowSize == WindowWidthSizeClass.Compact) {
                BottomBar(
                    NAVIGATION_ITEMS,
                    screenState.currentScreen,
                    onScreenSelected = onScreenSelected
                )
            }
        },
        content = { innerPadding ->
            Row(Modifier.padding(innerPadding)) {
                if (windowSize == WindowWidthSizeClass.Medium || windowSize == WindowWidthSizeClass.Expanded) {
                    NavigationRails(
                        NAVIGATION_ITEMS,
                        screenState.currentScreen,
                        onScreenSelected = onScreenSelected
                    )
                }
                when (screenState.currentScreen) {
                    is Screen.Home -> HomeScreen(imageResourceLoader) { onScreenSelected(it) }
                    is Screen.Search -> SearchScreen()
                    is Screen.Profile -> ProfileScreen()
                    is Screen.DetailSelectLanguage -> DetailSelectLanguageScreen(
                        screenState = screenState,
                        imageResourceLoader = imageResourceLoader,
                        onScreen = { onScreenSelected(it) },
                        onShowAlertDialog = { onShowAlertDialog(it) },
                        onShowSnackBar = { title -> onShowSnackBar(title) }
                    )
                }
            }
        }
    )
}