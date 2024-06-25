package com.damda.webapp.views.layouts

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexGrow
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun AppBar(title: String, isShowBackButton:Boolean = true, onBackArrowClick: () -> Unit, modifier: StyleScope.() -> Unit = {}) {
    Div(
        attrs = {
            style {
                width(100.percent)
                height(64.px)
                minHeight(64.px)
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.SpaceBetween)
                paddingLeft(16.px)
                paddingRight(26.px)
                backgroundColor(Color.transparent)
                boxSizing("border-box")
                modifier()
            }
        }
    ) {
        if (isShowBackButton) {
            Button(
                attrs = {
                    style {
                        backgroundColor(Color.transparent)
                        border(0.px)
                    }
                    onClick {
                        onBackArrowClick()
                    }
                }
            ) {
                Img(src = "ic_arrow_back.svg", attrs = { style { width(16.px); height(16.px) } })
            }
        }
        Span(
            attrs = {
                style {
                    fontSize(20.px)
                    fontWeight(500) // semibold
                    color(Color("#333333"))
                    textAlign("center")
                    flexGrow(1)
                }
            }
        ) {
            Text(title)
        }
        Button(
            attrs = {
                style {
                    backgroundColor(Color.transparent)
                    border(0.px)
                }
            }
        ) {
            Img(src = "ic_menu.svg", attrs = { style { width(4.px); height(16.px) } })
        }
    }
}

@Composable
fun ChatTopBar(title: String) {
    // 채팅 제목 및 참여자 정보
    Div({
        style {
            display(DisplayStyle.Flex)
            alignItems(AlignItems.Center)
            padding(16.px)
            fontWeight("bold")
            fontSize(20.px)
            // borderBottom(1.px, LineStyle.Solid, Color.Gray)
        }
    }) {
        Text(title)
    }
}