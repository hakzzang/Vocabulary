package com.damda.webapp.views.layouts

import androidx.compose.runtime.Composable
import com.damda.webapp.views.core.JSViewPadding
import com.damda.webapp.views.themes.innerContainerStyle
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.overflowY
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div

@Composable
fun JSColumn(
    horizontalAlign: AlignItems = AlignItems.FlexStart, // 기본값을 왼쪽 정렬로 설정
    verticalAlign: JustifyContent = JustifyContent.Center, // 기본값을 세로 중앙 정렬로 설정
    padding: JSViewPadding = JSViewPadding(0.px, 0.px, 0.px, 0.px),
    content: @Composable () -> Unit,
) {
    Div({
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            width(100.percent)
            height(100.percent)
            alignItems(horizontalAlign)
            justifyContent(verticalAlign) // 왼쪽에 붙도록 설정
            overflowY("auto")  // Enables vertical scrolling

            paddingLeft(padding.left)
            paddingTop(padding.top)
            paddingRight(padding.right)
            paddingBottom(padding.bottom)
            boxSizing("border-box")
        }
        style {
            // 수평 및 수직 스크롤바 숨기기
            property("-ms-overflow-style", "none") // IE and Edge
            property("scrollbar-width", "none") // Firefox
            property("::-webkit-scrollbar", "display:none") // Chrome, Safari, Opera
        }
    }) {
        content()
    }
}

@Composable
fun JSRow(
    alignItem: AlignItems = AlignItems.FlexStart, // 기본값을 왼쪽 정렬로 설정
    justifyContents: JustifyContent = JustifyContent.Center, // 기본값을 세로 중앙 정렬로 설정
    padding: JSViewPadding = JSViewPadding(0.px, 0.px, 0.px, 0.px),
    modifier: StyleScope.() -> Unit = {},
    content: @Composable () -> Unit,
) {
    Div({
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            alignItems(alignItem)
            justifyContent(justifyContents) // 왼쪽에 붙도록 설정

            paddingLeft(padding.left)
            paddingTop(padding.top)
            paddingRight(padding.right)
            paddingBottom(padding.bottom)
            boxSizing("border-box")
            modifier()
        }
    }) {
        content()
    }
}

@Composable
fun JSSpacer(width: CSSNumeric? = null, height: CSSNumeric? = null) {
    Div({
        style {
            width?.let { width(it) }
            height?.let { height(it) }
        }
    })
}

@Composable
fun VerticalLayout(
    modifier: StyleScope.() -> Unit = {}, content: @Composable () -> Unit
) {
    Div(attrs = {
        style {
            innerContainerStyle()
            modifier()
        }
    }) {
        content()
    }
}