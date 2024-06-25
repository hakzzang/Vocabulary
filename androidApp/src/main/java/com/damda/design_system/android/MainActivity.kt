package com.damda.design_system.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.damda.design_system.NativeMainApp
import com.damda.design_system.core.ImageResourceLoader

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NativeMainApp(ImageResourceLoader(this))
        }
    }
}