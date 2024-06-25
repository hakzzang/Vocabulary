package com.damda.webapp.views.texts

import androidx.compose.runtime.Composable
import com.damda.webapp.views.layouts.JSColumn
import com.damda.webapp.views.layouts.JSSpacer
import com.damda.webapp.views.core.JSViewPadding
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div

@Composable
fun JSHeaderText(
    title: String,
    subtitle: String,
    reduceFontSize: CSSSizeValue<CSSUnit.px> = 0.px
) {
    Div (
        {
            style {
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center) // 세로 가운데 정렬
            }
        }
    ){
        JSColumn {
            StyledText(
                text = subtitle,
                fontSize = 12.px,
                color = Color.gray,
                maxLines = 1,
                reduceFontSize = reduceFontSize
            )
            StyledText(
                text = title,
                fontSize = 18.px,
                fontWeight = "bold",
                maxLines = 1,
                reduceFontSize = reduceFontSize
            )
        }
    }
}

@Composable
fun JSHeaderSection(
    title: String,
    subtitle: String,
    actionText: String,
    padding: JSViewPadding = JSViewPadding(0.px, 0.px, 0.px, 0.px),
    reduceFontSize: CSSSizeValue<CSSUnit.px> = 0.px,
    onActionClick: () -> Unit
) {
    Div({
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            justifyContent(JustifyContent.SpaceBetween)
            alignItems(AlignItems.Center)
            width(100.percent)

            paddingLeft(padding.left)
            paddingTop(padding.top)
            paddingRight(padding.right)
            paddingBottom(padding.bottom)
            boxSizing("border-box")
        }
    }) {
        JSColumn {
            StyledText(title, 20.px - reduceFontSize, fontWeight = "bold", color = rgb(51, 51, 51))
            JSSpacer(height = 8.px)
            StyledText(subtitle, 14.px - reduceFontSize, rgb(176, 176, 176))
        }
        JSSpacer(width = 8.px)
//        ClickableText(
//            text = actionText,
//            onActionClick = onActionClick,
//            color = rgb(255, 167, 38),
//            fontWeight = "bold"
//        )
    }
}