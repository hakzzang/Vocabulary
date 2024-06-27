package com.damda.vocabulary.android

import android.content.res.AssetManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.damda.vocabulary.NativeMainApp
import com.damda.vocabulary.core.FontLoader
import com.damda.vocabulary.core.ImageResourceLoader
import com.damda.vocabulary.themes.LocalEmojiFontFamily
import com.damda.vocabulary.themes.LocalRegularFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NativeMainApp(ImageResourceLoader(this), FontLoader(this))
        }
    }
}