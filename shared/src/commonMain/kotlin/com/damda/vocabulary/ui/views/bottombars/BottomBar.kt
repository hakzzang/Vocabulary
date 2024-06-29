package com.damda.vocabulary.ui.views.bottombars

import androidx.compose.foundation.background
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.damda.vocabulary.ui.views.navigations.NavigationItem

@Composable
fun BottomBar(
    items: List<NavigationItem>,
    selectedItem: Int,
    backgroundColor: Color = MaterialTheme.colorScheme.background, // 테마에서 정의한 배경 색상 사용
    contentColor: Color = MaterialTheme.colorScheme.onBackground, // 테마에서 정의한 배경 위의 텍스트 색상 사용
    modifier: Modifier = Modifier,
    onItemSelected: (Int) -> Unit,
) {
    NavigationBar (modifier, containerColor = backgroundColor, contentColor = contentColor) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItem == index,
                onClick = { onItemSelected(index) },
                colors = if (selectedItem == index) NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onBackground,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground.copy(alpha = ContentAlpha.medium),
                    selectedTextColor = MaterialTheme.colorScheme.onBackground,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground.copy(alpha = ContentAlpha.medium),
                    indicatorColor = MaterialTheme.colorScheme.background
                ) else NavigationBarItemDefaults.colors(
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
