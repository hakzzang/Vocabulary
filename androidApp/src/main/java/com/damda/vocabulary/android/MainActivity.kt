package com.damda.vocabulary.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.damda.vocabulary.MainApp
import com.damda.vocabulary.core.FontLoader
import com.damda.vocabulary.core.ImageResourceLoader

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp(ImageResourceLoader(this), FontLoader(this))
        }
    }
}