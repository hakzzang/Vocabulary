package com.damda.design_system.ui.views.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(val icon: ImageVector, val label: String)

val NAVIGATION_ITEMS = listOf(
    NavigationItem(Icons.Default.Home, "Home"),
    NavigationItem(Icons.Default.Search, "Search"),
    NavigationItem(Icons.Default.AccountBox, "Profile")
)