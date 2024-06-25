package com.damda.webapp.views.layouts

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun QuantitySelector(
    currentQuantity: Int,
    isDecrementFilter: Boolean,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    width: CSSSizeValue<CSSUnit.px> = 78.px,
    height: CSSSizeValue<CSSUnit.px> = 33.px
) {
    val fontSize = (height.value / 2).px // 높이의 절반을 폰트 크기로 설정
    val padding = (height.value / 4).px // 높이의 1/4을 패딩으로 설정

    Div(
        attrs = {
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.SpaceBetween)
                this.width(width)
                this.height(height)
                backgroundColor(Color("#EC994B"))
                borderRadius(20.px)
            }
        }
    ) {
        Button(
            attrs = {
                onClick { if (isDecrementFilter) onDecrement() }
                style {
                    backgroundColor(Color.transparent)
                    border(0.px)
                    color(Color.white)
                    fontSize(fontSize)
                    fontWeight("bold")
                    padding(padding)
                }
            }
        ) {
            Text("-")
        }
        P(
            attrs = {
                style {
                    color(Color.white)
                    this.fontSize(fontSize)
                    fontWeight("bold")
                    this.padding(4.px)
                }
            }
        ) {
            Text("$currentQuantity")
        }
        Button(
            attrs = {
                onClick { onIncrement() }
                style {
                    backgroundColor(Color.transparent)
                    border(0.px)
                    color(Color.white)
                    this.fontSize(fontSize)
                    fontWeight("bold")
                    this.padding(padding)
                }
            }
        ) {
            Text("+")
        }
    }
}