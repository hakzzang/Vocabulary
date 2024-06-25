package com.damda.design_system.ui.views.views

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import com.damda.design_system.core.ImageResourceLoader

@Composable
fun LoadAndDisplayImage(
    imageResourceLoader: ImageResourceLoader,
    path: String
) {

    val imageState = remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(path) {
        imageState.value = imageResourceLoader.loadImageResource(path)
    }

    val image = imageState.value
    if (image != null) {
        Image(
            painter = BitmapPainter(image),
            contentDescription = null
        )
    } else {
    }
}