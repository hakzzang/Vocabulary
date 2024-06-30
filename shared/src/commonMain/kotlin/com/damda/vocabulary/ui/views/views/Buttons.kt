package com.damda.vocabulary.ui.views.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.damda.vocabulary.themes.Colors
import com.damda.vocabulary.ui.views.cards.CardBody
import com.damda.vocabulary.ui.views.cards.ShadowCard

@Composable
fun SelectButton(
    modifier: Modifier = Modifier, // Modifier 타입으로 변경
    backgroundColor: Color = Colors.secondaryColor, // Compose의 Color로 변경
    borderColor: Color = Color.Black, // Compose의 Color로 변경
    borderRadius: Dp = 16.dp, // CSSNumeric 대신 Dp 사용
    onClick: () -> Unit,
    title: String
) {
    ShadowCard(modifier, backgroundColor, borderColor, borderRadius, onClick) {
        CardBody (Modifier.fillMaxWidth(0.9f).padding(horizontal = 16.dp, vertical = 8.dp)) { Text(title, color = Color.Black) }
    }
}