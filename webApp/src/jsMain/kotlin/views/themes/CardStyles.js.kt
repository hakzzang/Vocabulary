package com.damda.webapp.views.themes

import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.overflowY
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.width

fun StyleScope.cardViewStyle() {
    width(100.percent)
    height(50.vh)
    overflow("hidden")
    boxSizing("border-box")
}

fun StyleScope.cardContentStyle() {
    width(100.percent)
    height(50.vh)
    padding(24.px)
    overflow("hidden")
    boxSizing("border-box")
}

fun StyleScope.matchParentStyle() {
    width(100.percent)
    height(100.percent)
}

fun StyleScope.innerContainerHorizontalCenterStyle() {
    flexDirection(FlexDirection.Column) // 세로 정렬을 위한 설정
    display(DisplayStyle.Flex)
    justifyContent(JustifyContent.Start)
    alignItems(AlignItems.Start)
    overflow("hidden")
    boxSizing("border-box")
}

fun StyleScope.innerContainerStyle() {
    flexDirection(FlexDirection.Column) // 세로 정렬을 위한 설정
    display(DisplayStyle.Flex)
    justifyContent(JustifyContent.FlexStart) // 가로 정렬을 시작 위치로 설정
    alignItems(AlignItems.Stretch)
    overflow("hidden")
    boxSizing("border-box")
}

fun StyleScope.strokeBoldCardStyle() {
    width(100.percent)
    border(1.px, LineStyle.Solid, Color.black)
    backgroundColor(Color.white)
    borderRadius(16.px)
    property("box-shadow", "6px 6px 0px rgba(0, 0, 0, 1)") // 그림자 추가
    overflow("hidden")
    boxSizing("border-box")
}

fun StyleScope.strokeCardStyle() {
    width(100.percent)
    border(1.5.px, LineStyle.Solid, Color.black)
    backgroundColor(Color.white)
    borderRadius(16.px)
    property("box-shadow", "1px 1px 0px rgba(0, 0, 0, 0.1)") // 그림자 추가
    overflow("hidden")
    boxSizing("border-box")
}

fun StyleScope.fullContainerStyle() {
    width(100.percent)
    height(100.vh - 104.px)
}

fun StyleScope.textStyle() {
    flexDirection(FlexDirection.Column)
    height(28.percent)
    justifyContent(JustifyContent.FlexStart)
    padding(16.px)
    fontSize(18.px)
    overflowY("auto")
    alignItems(AlignItems.Start)
}

fun StyleScope.cardHeaderStyle() {
    width(100.percent)
    height(72.percent)
    borderRadius(topLeft = 16.px, topRight = 16.px, 0.px, 0.px)
    property("box-shadow", "0px 2px 8px rgba(0, 0, 0, 0.1)")
}

fun StyleScope.cardBodyStyle() {
    width(100.percent)
    height(28.percent)
}

fun StyleScope.textSectionStyle() {
    flexDirection(FlexDirection.Column) // 세로 정렬을 위한 설정
    justifyContent(JustifyContent.FlexStart)
    padding(16.px)
    fontSize(18.px)
    overflowY("auto") // 스크롤바 추가
    alignItems(AlignItems.Start) // 왼쪽 정렬
}