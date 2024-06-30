package com.damda.vocabulary.themes


import androidx.compose.material3.*
import androidx.compose.runtime.Composable

val VocabularyColorScheme = lightColorScheme(
    primary = Colors.primaryColor,
    primaryContainer = Colors.backgroundColor,
    secondary = Colors.secondaryColor,
    background = Colors.backgroundColor,
    onBackground = Colors.onBackgroundColor
)


// 사용자 정의 타이포그래피 설정
val MyCustomTypography = Typography()

// 사용자 정의 모양 설정
val MyCustomShapes = Shapes()

// 사용자 정의 MaterialTheme
@Composable
fun VocabularyTheme(content: @Composable () -> Unit) {
    MaterialTheme (
        colorScheme = VocabularyColorScheme,
        typography = MyCustomTypography,
        shapes = MyCustomShapes,
        content = content
    )
}