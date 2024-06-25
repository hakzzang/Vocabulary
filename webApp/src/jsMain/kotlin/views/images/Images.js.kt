package com.damda.webapp.views.images

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.damda.vocabulary.core.ImageResourceLoader
import com.damda.vocabulary.core.ImageResult
import com.damda.webapp.views.layouts.JSCircularProgressIndicator
import com.damda.webapp.views.core.JSViewPadding
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.maxHeight
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.minWidth
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.w3c.dom.HTMLImageElement

@Composable
fun ResizableJSImage(
    imageName: String,
    minWidth: CSSSizeValue<out CSSUnit> = 373.px,
    minHeight: CSSSizeValue<out CSSUnit> = 317.px,
    maxHeight: CSSSizeValue<out CSSUnit> = 60.vh,
    radius: CSSSizeValue<out CSSUnit> = 20.px,
    padding: JSViewPadding = JSViewPadding(0.px, 0.px, 0.px, 0.px)
) {
    Div(
        attrs = {
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.Center)
                alignItems(AlignItems.Center)
                width(100.percent)
                height(100.percent)
                overflow("hidden") // 부모 요소를 넘어가는 부분을 숨기기
                borderRadius(radius)

                paddingLeft(padding.left)
                paddingTop(padding.top)
                paddingRight(padding.right)
                paddingBottom(padding.bottom)
                boxSizing("border-box") // 패딩을 포함한 전체 크기를 조정
            }
        }
    ) {
        Img(
            src = imageName,
            attrs = {
                style {
                    minWidth(minWidth)
                    minHeight(minHeight)
                    width(100.percent)
                    height(auto)
                    maxHeight(maxHeight) // 최대 높이 설정
                    property("object-fit", "cover")
                    borderRadius(radius) // 이미지에 둥근 테두리 적용
                }
            }
        )
    }
}


@Composable
fun JSImage(
    url: String,
    attrs: AttrBuilderContext<HTMLImageElement>? = null
) {
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(url) {
        isLoading = false
    }

    Img(src = url, attrs = attrs)
}

@Composable
fun JSRoundedImage(
    url: String,
    contentDescription: String = "",
    size: Int = 42,
    borderColor: CSSColorValue = Color.black, // 윤곽선 색상
    borderWidth: CSSNumeric = 2.px // 윤곽선 두께
) {
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(url) {
        isLoading = false
    }

    Div({
        style {
            width(size.px)
            height(size.px)
            borderRadius(50.percent)
            border {
                style = LineStyle.Solid
                color = borderColor
                width = borderWidth
            }
            overflow("hidden")

            display(DisplayStyle.Flex)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
            boxSizing("border-box") // 테두리와 함께 정사각형을 유지하도록 설정
        }
    }) {
        if (isLoading) {
            JSCircularProgressIndicator()
        } else {
            Div({
                style {
                    width(100.percent)
                    height(100.percent)
                    display(DisplayStyle.Flex)
                    justifyContent(JustifyContent.Center)
                    alignItems(AlignItems.Center)
                }
            }) {
                Img(
                    src = url,
                    alt = contentDescription,
                    attrs = {
                        style {
                            width(90.percent)
                            height(90.percent)
                            property("object-fit", "cover")
                        }
                    }
                )
            }
        }
    }
}