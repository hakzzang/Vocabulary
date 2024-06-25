package com.damda.webapp.views.layouts

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import com.damda.webapp.views.themes.cardHeaderStyle
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.outlineColor
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

@Composable
fun CardView(
    modifier: StyleScope.() -> Unit = {},
    backgroundColor: CSSColorValue = Color.white,
    borderColor: CSSColorValue = Color.black,
    borderRadius: CSSNumeric = 16.px,
    content: @Composable () -> Unit
) {
    Div(
        attrs = {
            style {
                backgroundColor(backgroundColor)
                outlineColor(borderColor)
                property("box-shadow", "6px 6px 0px rgba(0, 0, 0, 1)") // 그림자 추가
                borderRadius(borderRadius)
                modifier()
                overflow("hidden")
                boxSizing("border-box")
            }
        }
    ) {
        content()
    }
}

@Composable
fun Card(
    modifier: StyleScope.() -> Unit = {},
    borderRadius: CSSNumeric = 16.px,
    borderColor: CSSColorValue = Color.black,
    clickListener: ((SyntheticMouseEvent) -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Div(
        attrs = {
            style {
                outlineColor(borderColor)
                borderRadius(borderRadius)
                modifier()
            }
            onClick {
                clickListener?.invoke(it)
            }
        }
    ) {
        content()
    }
}

@Composable
fun CardHeader(modifier: StyleScope.() -> Unit, content: @Composable () -> Unit) {
    CardView(
        modifier = {
            cardHeaderStyle()
            modifier()
        },
        content = {
            content()
        }
    )
}

@Composable
fun CardBody(modifier: StyleScope.() -> Unit, content: @Composable () -> Unit) {
    Div(attrs = {
        style {
            modifier()
        }
    }) { content() }
}