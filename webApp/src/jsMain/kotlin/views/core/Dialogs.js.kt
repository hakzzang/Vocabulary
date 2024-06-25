package com.damda.webapp.views.core

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun DialogMessage(onClose: () -> Unit, content: @Composable () -> Unit) {
    Div(
        attrs = {
            style {
                position(Position.Fixed)
                top(0.px)
                left(0.px)
                width(100.percent)
                height(100.percent)
                backgroundColor(rgba(0, 0, 0, 0.5)) // 반투명 배경
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.Center)
                alignItems(AlignItems.Center)
            }
            onClick { onClose() } // 배경 클릭 시 닫기
        }
    ) {
        Div(
            attrs = {
                style {
                    backgroundColor(Color.white)
                    padding(24.px)
                    borderRadius(8.px)
                    property("box-shadow", "0px 4px 4px rgba(0, 0, 0, 0.25)")
                }
                onClick { it.stopPropagation() } // 다이얼로그 내부 클릭 시 닫히지 않도록 함
            }
        ) {
            content()
            Button(attrs = {
                onClick { onClose() }
            }) {
                Text("Close")
            }
        }
    }
}