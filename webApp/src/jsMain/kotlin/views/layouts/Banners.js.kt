package com.damda.webapp.views.layouts

import androidx.compose.runtime.Composable
import com.damda.design_system.core.ImageResourceLoader
import com.damda.webapp.views.images.JSImage
import com.damda.webapp.views.texts.StyledText
import com.damda.webapp.views.core.JSViewPadding
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
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
fun JSLargeBanner(
    imageResourceLoader: ImageResourceLoader,
    imageName: String,
    title: String,
    subtitle: String,
    buttonText: String,
    padding: JSViewPadding = JSViewPadding(0.px, 0.px, 0.px, 0.px),
    reduceFontSize: CSSSizeValue<CSSUnit.px> = 0.px,
    onButtonClick: () -> Unit
) {
    Div (
        attrs = {
            style {
                width(100.percent)

                paddingLeft(padding.left)
                paddingTop(padding.top)
                paddingRight(padding.right)
                paddingBottom(padding.bottom)
                boxSizing("border-box")
            }
        }
    ){
        Div (
            attrs = {
                style {
                    width(100.percent)
                    height(172.px)
                    backgroundColor(rgb(255, 167, 38)) // #FFA726
                    borderRadius(16.px)
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Row)
                    alignItems(AlignItems.Center) // 세로 중앙 정렬
                    justifyContent(JustifyContent.FlexStart) // 왼쪽 정렬
                }
            }
        ) {
            JSRow(
                horizontalAlign = AlignItems.Center,
                verticalAlign = JustifyContent.Center
            ){
                JSSpacer(width = 16.px)
                JSImage(
                    url = imageName,
                    attrs = {
                        style {
                            width(160.px)
                            height(151.px)
                        }
                    }
                )
                JSSpacer(width = 16.px)
                JSColumn (
                    horizontalAlign = AlignItems.Start,
                    verticalAlign = JustifyContent.Center) {
                    StyledText(
                        text = subtitle,
                        fontSize = 14.px,
                        color = Color.white,
                        reduceFontSize = reduceFontSize
                    )
                    JSSpacer(height = 8.px)
                    StyledText(
                        text = title,
                        fontSize = 18.px,
                        color = Color.white,
                        reduceFontSize = reduceFontSize,
                        maxLines = 2,
                        fontWeight = "bold"
                    )
                }
                JSSpacer(width = 16.px)
            }
        }
    }
}