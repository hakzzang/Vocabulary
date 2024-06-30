package com.damda.vocabulary.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.damda.vocabulary.ui.views.RegularText
import com.damda.vocabulary.ui.views.cards.CardBody
import com.damda.vocabulary.ui.views.cards.ShadowCard

@Composable
fun LanguageSelectionList(imageResourceLoader: ImageResourceLoader) {
    var arrowRightIconBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(Unit) {
        arrowRightIconBitmap = imageResourceLoader.loadImageResource("arrow_right.png")
    }

    val languages = listOf("Korean", "English", "Japanese")

    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        languages.map { language ->
            ShadowCard {
                arrowRightIconBitmap?.let { arrowRightIcon ->
                    LanguageSelectionItem(language, arrowRightIcon)
                }
            }
        }
    }
}

@Composable
fun LanguageSelectionItem(language: String, arrowRightIcon: ImageBitmap) {
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