package com.damda.vocabulary.android

import android.app.Application
import com.damda.vocabulary.di.KoinInit

class TemplateApp : Application() {
    override fun onCreate() {
        super.onCreate()

        KoinInit.init {
        }
    }
}