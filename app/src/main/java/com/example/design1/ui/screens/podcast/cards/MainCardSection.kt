package com.example.design1.ui.screens.podcast.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.design1.R
import com.example.design1.ui.bigSubtitleLeftStyle
import com.example.design1.ui.bodySmallCenteredStyle
import com.example.design1.ui.bodySmallLeftStyle
import com.example.design1.ui.captionXSmallLeftStyle
import com.example.design1.ui.h4Style
import com.example.design1.ui.smallTitleStyle

@Composable
internal fun MainCardSection(
    weekScroll: ScrollState,
    onDateClick: (WeekDayUi) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF292423), RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(listOf(Color(0xFFFE6847), Color(0xFF642D20))),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.height(36.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy((-5.51).dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar_left_463f98),
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFF574C47), CircleShape)
                        .border(1.57.dp, Color(0x80FFFFFF), CircleShape)
                        .padding(4.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.avatar_right_49fcaf),
                    contentDescription = null,
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFFFD89C), CircleShape)
                        .border(1.57.dp, Color(0x80FFFFFF), CircleShape)
                        .padding(4.dp)
                        .clip(CircleShape)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text("Between the Lines", color = Color.White, style = h4Style())
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                "Your weekly activity turned into a personalized podcast to analyze process effectively",
                color = Color.White.copy(alpha = 0.9f),
                style = bodySmallLeftStyle(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CountdownItem("6", "Days")
                Text(":", color = Color.White, style = smallTitleStyle())
                CountdownItem("23", "Hours")
                Text(":", color = Color.White, style = smallTitleStyle())
                CountdownItem("32", "Minutes")
                Text(":", color = Color.White, style = smallTitleStyle())
                CountdownItem("40", "Seconds")
            }
            Spacer(modifier = Modifier.height(24.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .clip(RoundedCornerShape(100.dp))
                        .background(Color(0x66F2EBE9))
                        .padding(vertical = 14.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Start Listening",
                        color = Color(0xFF171312),
                        style = bigSubtitleLeftStyle().copy(fontWeight = FontWeight.SemiBold)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "💫 Keep engaging - The more you journal, dream, and reflect, the richer your weekly podcast becomes",
                color = Color(0xFFFFCDC2),
                textAlign = TextAlign.Center,
                style = bodySmallCenteredStyle()
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF221D1B))
                .horizontalScroll(weekScroll)
                .padding(vertical = 16.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val days = listOf(
                WeekDayUi("Mo", "15", isCompleted = true),
                WeekDayUi("Tue", "16", isCompleted = true),
                WeekDayUi("We", "17", isCompleted = true, showIndicatorDots = true),
                WeekDayUi("Fri", "19", isSelected = true, showIndicatorDots = true),
                WeekDayUi("Thu", "18", isDisabled = true),
                WeekDayUi("Sat", "20", isDisabled = true),
                WeekDayUi("Sun", "21", isDisabled = true)
            )
            days.forEach { day -> WeekDayCell(day = day, onClick = { onDateClick(day) }) }
        }
    }
}

@Composable
private fun CountdownItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, color = Color.White, style = smallTitleStyle())
        Text(text = label, color = Color.White.copy(alpha = 0.6f), style = captionXSmallLeftStyle())
    }
}

