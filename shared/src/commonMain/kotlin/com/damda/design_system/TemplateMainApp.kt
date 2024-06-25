package com.damda.design_system

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.damda.design_system.core.ImageResourceLoader
import com.damda.design_system.ui.HomeScreen
import com.damda.design_system.ui.ProfileScreen
import com.damda.design_system.ui.SearchScreen
import com.damda.design_system.ui.views.bottombars.BottomBar
import com.damda.design_system.ui.views.bottombars.NavigationRails
import com.damda.design_system.ui.views.navigations.NAVIGATION_ITEMS
import com.damda.design_system.ui.views.views.LoadAndDisplayImage

@Composable
fun NativeMainApp(
    imageResourceLoader: ImageResourceLoader
) {
    var selectedItem by remember { mutableStateOf(0) }
    val windowSize = rememberWindowSize()

    Scaffold(bottomBar = {
        if (windowSize == WindowWidthSizeClass.Compact) {
            BottomBar(NAVIGATION_ITEMS, selectedItem) { selectedItem = it }
        }
    }) { innerPadding ->
        Row(Modifier.padding(innerPadding)) {
            if (windowSize == WindowWidthSizeClass.Medium || windowSize == WindowWidthSizeClass.Expanded) {
                NavigationRails(NAVIGATION_ITEMS, selectedItem) { selectedItem = it }
            }
            LoadAndDisplayImage(imageResourceLoader, "pic8.jpg")
            Box(modifier = Modifier.padding(innerPadding).weight(1f)) {
                when (selectedItem) {
                    0 -> HomeScreen()
                    1 -> SearchScreen()
                    2 -> ProfileScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun rememberWindowSize(): WindowWidthSizeClass {
    // 간단히 화면 너비를 기준으로 WindowSize를 결정
    val windowSize = calculateWindowSizeClass()
    return windowSize.widthSizeClass
}