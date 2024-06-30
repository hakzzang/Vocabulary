package com.damda.vocabulary.ui.state

data class SnackbarState(
    val title: String,
    val onDismiss: (() -> Unit)? = null
)