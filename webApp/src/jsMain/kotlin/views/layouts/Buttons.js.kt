package com.damda.webapp.views.layouts

import androidx.compose.runtime.Composable
import com.damda.webapp.views.themes.strokeCardStyle
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.bottom
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.cursor
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.marginRight
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.right
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun JSFloatingActionButton(onClick: () -> Unit) {
    Div({
        onClick { onClick() }
        style {
            display(DisplayStyle.Flex)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
            width(32.px)
            height(32.px)
            backgroundColor(rgb(255, 167, 38))
            color(Color.white)
            borderRadius(50.percent)
            property("box-shadow", "0px 4px 4px rgba(0, 0, 0, 0.25)")
            cursor("pointer")
            position(Position.Absolute)
            bottom(18.px)
            right(18.px)
        }
    }) {
        Text("+")
    }
}

@Composable
fun WidthFullSizeButton(
    title: String,
    onClick: () -> Unit,
    reduceFontSize: CSSSizeValue<CSSUnit.px> = 0.px
) {
    Button(
        attrs = {
            onClick { onClick() }
            style {
                width(100.percent)
                height(70.px)
                backgroundColor(Color("#EC994B"))
                border(0.px)
                color(Color.white)
                fontSize(20.px - reduceFontSize)
                fontWeight("bold")
                padding(12.px)
                borderRadius(30.px)
            }
        }
    ) {
        Text(title)
    }
}

@Composable
fun ActionButton(text: String, backgroundColor: CSSColorValue) {
    Card(modifier = {
        strokeCardStyle()
        marginLeft(12.px)
        marginTop(12.px)
        marginRight(12.px)
        width(100.vh)
        height(47.px)
        backgroundColor(backgroundColor)
        alignItems(AlignItems.Center)
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
    }) {
        Text(text)
    }
}