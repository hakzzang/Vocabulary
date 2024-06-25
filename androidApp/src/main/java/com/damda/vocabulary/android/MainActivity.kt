package com.damda.vocabulary.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.damda.vocabulary.NativeMainApp
import com.damda.vocabulary.core.ImageResourceLoader

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NativeMainApp(ImageResourceLoader(this))
        }
    }
}