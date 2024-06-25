package com.damda.webapp.views.layouts

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div

@Composable
fun JSCircularProgressIndicator() {
    Div({
        style {
            width(24.px)
            height(24.px)
            borderRadius(50.percent)
            border {
                style = LineStyle.Solid
                width = 2.px
            }
        }
    }) {}
}