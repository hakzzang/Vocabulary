package com.damda.webapp.views.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.textDecoration
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun NavBar() {
    Div(attrs = {
        style {
            width(100.percent) // Viewport width
            height(72.px)
            display(DisplayStyle.Flex)
            justifyContent(JustifyContent.SpaceBetween)
            alignItems(AlignItems.Center)
            backgroundColor(rgb(28, 28, 28))
            paddingLeft(32.px)
            paddingRight(32.px)
            boxSizing("border-box")
        }
    }) {
        // Left side links
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                gap(20.px)
            }
        }) {
            NavLink("Home", "#", true)
//            NavLink("Products", "#")
//            NavLink("Prices", "#")
//            NavLink("Blog", "#")
        }

        // Right side icons
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                gap(15.px)
            }
        }) {
            SocialIcon("insta")
            SocialIcon("naver")
        }
    }
}

@Composable
fun NavLink(text: String, href: String, isActive: Boolean = false) {
    var isHovered by remember { mutableStateOf(false) }

    A(href, attrs = {
        style {
            color(if (isActive || isHovered) Color("#ea8c34") else Color.white)
            textDecoration("none")
            fontSize(18.px)
            padding(10.px)
        }
        onMouseEnter {
            isHovered = true
        }
        onMouseLeave {
            isHovered = false
        }
    }) {
        Text(text)
    }
}

@Composable
fun SocialIcon(platform: String) {
    val iconUrl = when (platform) {
        "insta" -> "ic_insta.png"
        "naver" -> "ic_naver.png"
        "facebook" -> "ic_insta.png"
        else -> ""
    }
    val iconHrefUrl = when (platform) {
        "insta" -> "https://www.instagram.com/hedgehog_eulji"
        "naver" -> "https://naver.me/xbA4ntAF"
        "facebook" -> "ic_insta.png"
        else -> ""
    }


    A(href = iconHrefUrl, attrs = {
        target(ATarget.Blank) // 새 탭에서 열기
        style { margin(0.px, 10.px) }
    }) {
        Img(src = iconUrl, attrs = {
            style { width(24.px); height(24.px) }
        })
    }

}

@Composable
fun JSFooter() {
    Div(attrs = {
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            alignItems(AlignItems.Center)
            justifyContent(JustifyContent.Center)
            textAlign("center")
            color(Color.white)
            backgroundColor(Color.black)
            width(100.percent)
            height(100.percent)
            padding(16.px)
            boxSizing("border-box") // 포함하는 부모 요소에 맞게 사이즈 조정
        }
    }) {
        P { Text("HEDGEHOG (대표: KSW)") }
        P { Text("서울 중구 을지로33길 6 4층") }
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.Center)
                marginTop(10.px)
                marginBottom(10.px)
            }
        }) {
            A(href = "https://naver.me/xbA4ntAF", attrs = {
                target(ATarget.Blank) // 새 탭에서 열기
                style {
                    margin(0.px, 10.px)
                }
            }) {
                Img(src = "ic_naver.png", attrs = {
                    style { width(24.px); height(24.px);  }
                })
            }

            A(href = "https://www.instagram.com/hedgehog_eulji", attrs = {
                target(ATarget.Blank) // 새 탭에서 열기
                style {
                    margin(0.px, 10.px)
                }
            }) {
                Img(src = "ic_insta.png", attrs = {
                    style { width(24.px); height(24.px);  }
                })
            }
        }
    }
}