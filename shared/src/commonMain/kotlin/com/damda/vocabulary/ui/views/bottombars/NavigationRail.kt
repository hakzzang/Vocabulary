package com.damda.vocabulary.ui.views.bottombars

import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.damda.vocabulary.ui.Screen
import com.damda.vocabulary.ui.views.navigations.NavigationItem

@Composable
fun NavigationRails(
    items: List<NavigationItem>,
    currentScreen: Screen,
    backgroundColor: Color = MaterialTheme.colorScheme.background, // 테마에서 정의한 배경 색상 사용
    contentColor: Color = MaterialTheme.colorScheme.onBackground, // 테마에서 정의한 배경 위의 텍스트 색상 사용
    onScreenSelected: (Screen) -> Unit
) {
    NavigationRail(containerColor = backgroundColor, contentColor = contentColor) {
        items.forEachIndexed { index, item ->
            val selected = when (index) {
                0 -> currentScreen is Screen.Home
                1 -> currentScreen is Screen.Search
                2 -> currentScreen is Screen.Profile
                else -> false
            }
            NavigationRailItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selected,
                onClick = {
                    val screen = when (index) {
                        0 -> Screen.Home
                        1 -> Screen.Search
                        2 -> Screen.Profile
                        else -> return@NavigationRailItem
                    }
                    onScreenSelected(screen)
                },
                colors = if (selected) NavigationRailItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onBackground,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground.copy(alpha = ContentAlpha.medium),
                    selectedTextColor = MaterialTheme.colorScheme.onBackground,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground.copy(alpha = ContentAlpha.medium),
                    indicatorColor = MaterialTheme.colorScheme.background
                ) else NavigationRailItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onBackground,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground.copy(alpha = ContentAlpha.medium),
                    selectedTextColor = MaterialTheme.colorScheme.onBackground,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground.copy(alpha = ContentAlpha.medium),
                    indicatorColor = MaterialTheme.colorScheme.background
                )
            )
        }
    }
}