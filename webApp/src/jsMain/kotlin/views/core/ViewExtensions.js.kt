package com.damda.webapp.views.core

import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit

data class JSViewPadding(
    val left: CSSSizeValue<CSSUnit.px>,
    val top: CSSSizeValue<CSSUnit.px>,
    val right: CSSSizeValue<CSSUnit.px>,
    val bottom: CSSSizeValue<CSSUnit.px>
)