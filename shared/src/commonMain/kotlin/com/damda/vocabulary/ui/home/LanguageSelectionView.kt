package com.damda.vocabulary.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import com.damda.vocabulary.core.ImageResourceLoader
import com.damda.vocabulary.ui.Screen
import com.damda.vocabulary.ui.views.RegularText
import com.damda.vocabulary.ui.views.cards.CardBody
import com.damda.vocabulary.ui.views.cards.ShadowCard

@Composable
fun SelectionList(
    selections: List<String> = listOf("Korean", "English", "Japanese"),
    imageResourceLoader: ImageResourceLoader,
    onScreen: (Screen) -> Unit
) {
    var arrowRightIconBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(Unit) {
        arrowRightIconBitmap = imageResourceLoader.loadImageResource("arrow_right.png")
    }

    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        selections.map { language ->
            ShadowCard(onClick = { onScreen(Screen.DetailSelectLanguage(language)) }) {
                arrowRightIconBitmap?.let { arrowRightIcon ->
                    SelectionItem(language, arrowRightIcon)
                }
            }
        }
    }
}

@Composable
fun SelectionItem(language: String, arrowRightIcon: ImageBitmap) {
    CardBody(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Row {
            RegularText(language, color = Color.Black)
            Image(
                bitmap = arrowRightIcon,
                contentDescription = "arrow_right",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}