package com.damda.design_system.ui.views.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.damda.design_system.core.ImageResourceLoader

@Composable
fun RoundedImage(
    imageResourceLoader: ImageResourceLoader,
    imageResName: String,
    contentDescription: String,
    size: Int = 40
) {
    var bitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    var isLoading by remember { mutableStateOf(true) }


    LaunchedEffect(imageResName) {
        bitmap = imageResourceLoader.loadImageResource(imageResName)
        isLoading = false
    }

    Box(modifier = Modifier.size(size.dp)) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            bitmap?.let {
                Image(
                    bitmap = it,
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .size(size.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun IconImage(
    imageResourceLoader: ImageResourceLoader,
    imageResName: String,
    contentDescription: String,
    size: Int = 24
) {
    var bitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(imageResName) {
        bitmap = imageResourceLoader.loadImageResource(imageResName)
        isLoading = false
    }

    Box(modifier = Modifier.size(size.dp)) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            bitmap?.let {
                Image(
                    bitmap = it,
                    contentDescription = contentDescription,
                    modifier = Modifier.size(size.dp)
                )
            }
        }
    }
}