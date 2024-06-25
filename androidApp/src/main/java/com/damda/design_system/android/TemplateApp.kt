package com.damda.design_system.android

import android.app.Application
import com.damda.design_system.di.KoinInit

class TemplateApp : Application() {
    override fun onCreate() {
        super.onCreate()

        KoinInit.init {
        }
    }
}