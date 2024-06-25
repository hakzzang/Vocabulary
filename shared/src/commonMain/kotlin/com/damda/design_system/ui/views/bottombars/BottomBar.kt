package com.damda.design_system.ui.views.bottombars

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.damda.design_system.ui.views.navigations.NavigationItem

@Composable
fun BottomBar(
    items: List<NavigationItem>,
    selectedItem: Int,
    modifier: Modifier = Modifier,
    onItemSelected: (Int) -> Unit,
) {
    NavigationBar (modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItem == index,
                onClick = { onItemSelected(index) }
            )
        }
    }
}
