package com.damda.vocabulary.ui.views.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.damda.vocabulary.core.ImageResourceLoader
import com.damda.vocabulary.ui.views.EmojiText
import com.damda.vocabulary.ui.views.RegularText
import com.damda.vocabulary.ui.views.views.AsyncImage

@Composable
fun GreetingCardSection(imageResourceLoader: ImageResourceLoader) {
    ShadowCard {
        Column {
            // Image 영역
            CardHeader(
                imageResourceLoader = imageResourceLoader,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            )

            // Text 영역
            CardBody(modifier = Modifier.padding(16.dp)) {
                RegularText(
                    text = "한국어 학습",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                EmojiText(
                    text = "\uD83D\uDD70\uFE0F 시작: 2024년 6월 29일, 오전 1시31분",
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                EmojiText(
                    text = "\uD83D\uDCCD 챕터3까지 학습을 진행했습니다.",
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                RegularText(
                    text = "시작해볼까요?",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun ShadowCard(
    modifier: Modifier = Modifier, // Modifier 타입으로 변경
    backgroundColor: Color = Color.White, // Compose의 Color로 변경
    borderColor: Color = Color.Black, // Compose의 Color로 변경
    borderRadius: Dp = 16.dp, // CSSNumeric 대신 Dp 사용
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .drawBehind { // 커스텀 그림자를 그리기 위해 drawBehind 사용
                val shadowColor = Color.Black.copy(alpha = 1f) // 그림자 색상 설정
                val paint = Paint().apply { this.color = shadowColor } // 그림자 색상을 가진 Paint 객체 생성
                val path = Path().apply { // 그림자 경로 설정
                    addRoundRect(
                        RoundRect(
                            left = 6.dp.toPx(), // 그림자의 왼쪽 오프셋
                            top = 6.dp.toPx(), // 그림자의 위쪽 오프셋
                            right = size.width + 6.dp.toPx(), // 그림자의 오른쪽 오프셋
                            bottom = size.height + 6.dp.toPx(), // 그림자의 아래쪽 오프셋
                            cornerRadius = CornerRadius(
                                borderRadius.toPx(),
                                borderRadius.toPx()
                            ) // 모서리 곡률 설정
                        )
                    )
                }
                drawIntoCanvas { // 캔버스에 그림자를 그림
                    it.drawPath(path, paint)
                }
            }
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(borderRadius)
            ) // 배경 색상과 모서리 곡률 설정
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(borderRadius)
            ) // 테두리 색상과 두께 설정
            .clip(RoundedCornerShape(borderRadius)) // 모서리 자르기
    ) {
        content() // 콘텐츠를 표시
    }
}

@Composable
fun CardHeader(imageResourceLoader: ImageResourceLoader, modifier: Modifier = Modifier) {
    AsyncImage(
        imageResourceLoader = imageResourceLoader,
        imageResName = "pic8.jpg",
        modifier = modifier
    )
}

@Composable
fun CardBody(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(modifier = modifier) {
        content()
    }
}