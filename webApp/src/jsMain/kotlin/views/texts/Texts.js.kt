package com.damda.webapp.views.texts

import androidx.compose.runtime.Composable
import com.damda.webapp.views.core.JSViewPadding
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.lineHeight
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.whiteSpace
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun StyledText(
    text: String,
    fontSize: CSSNumeric = 16.px,
    color: CSSColorValue = Color.black,
    maxLines: Int = 2,
    fontWeight: String? = null,
    widthValue: CSSNumeric = 100.percent,
    padding: JSViewPadding = JSViewPadding(0.px, 0.px, 0.px, 0.px),
    reduceFontSize: CSSSizeValue<CSSUnit.px> = 0.px
) {
    Div({
        style {
            this.width(widthValue)
            this.fontSize(fontSize - reduceFontSize)
            this.color(color)
            if (fontWeight != null) {
                this.fontWeight(fontWeight)
            }
            overflow("hidden")
            property("text-overflow", "ellipsis")
            whiteSpace("normal")

            property("display", "-webkit-box")
            property("-webkit-line-clamp", maxLines)
            property("-webkit-box-orient", "vertical")

            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            lineHeight("1.2em")

            paddingLeft(padding.left)
            paddingTop(padding.top)
            paddingRight(padding.right)
            paddingBottom(padding.bottom)
            boxSizing("border-box")
        }
    }) {
        Text(text)
    }
}

@Composable
fun ClickableText(
    text: String,
    onActionClick: () -> Unit,
    color: CSSColorValue = Color.black,
    fontWeight: String? = null,
    maxLines: Int = 1
) {
    Span(
        attrs = {
            onClick { onActionClick() }
            style {
                cursor("pointer")
                color(color)
                if (fontWeight != null) {
                    this.fontWeight(fontWeight)
                }
                if (maxLines == 1) {
                    whiteSpace("nowrap")
                } else {
                    property("display", "-webkit-box")
                    property("-webkit-box-orient", "vertical")
                    property("-webkit-line-clamp", maxLines.toString())
                    overflow("hidden")
                }
            }
        }
    ) {
        Text(text)
    }
}
