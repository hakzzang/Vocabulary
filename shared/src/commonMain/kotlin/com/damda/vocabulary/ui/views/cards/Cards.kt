package com.damda.vocabulary.ui.views.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.damda.vocabulary.core.ImageResourceLoader
import com.damda.vocabulary.ui.views.EmojiText
import com.damda.vocabulary.ui.views.RegularText
import com.damda.vocabulary.ui.views.views.AsyncImage

@Composable
fun GreetingCardSection(imageResourceLoader: ImageResourceLoader) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(6.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Column {
            // Image 영역
            CardHeader(imageResourceLoader)

            // Text 영역
            CardBody()
        }
    }
}

@Composable
fun CardHeader(imageResourceLoader: ImageResourceLoader) {
    AsyncImage(
        imageResourceLoader = imageResourceLoader,
        imageResName = "pic8.jpg",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    )
}

@Composable
fun CardBody() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        RegularText(
            text = "결혼 주요 정보",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        EmojiText(
            text = "\uD83D\uDD70\uFE0F 시간: 2024년 10월 20일, 오전 11시 30분",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        EmojiText(
            text = "\uD83D\uDCCD 위치: 경기 성남시 분당구 탄천상로 151번길 20",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        RegularText(
            text = "분당앤스퀘어 예식장 (오리역 6번출구 앞)",
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}