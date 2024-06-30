package com.damda.vocabulary.ui.state

import com.damda.vocabulary.ui.Level
import com.damda.vocabulary.ui.Screen

data class AlertState(
    val title: String,
    val content: String,
    val onDismiss: (() -> Unit)? = null,
    val onConfirm: (() -> Unit)? = null
)