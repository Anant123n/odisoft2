package com.example.design1.ui.screens.podcast.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design1.R
import com.example.design1.ui.bodySmallLeftStyle
import com.example.design1.ui.captionSmallLeftStyle
import com.example.design1.ui.captionXSmallLeftStyle

@Composable
internal fun WeekDayCell(day: WeekDayUi, onClick: () -> Unit) {
    val textColor = if (day.isDisabled) Color(0xFFB6B0AF).copy(alpha = 0.4f) else Color.White
    val subTextColor = if (day.isDisabled) Color(0xFFB6B0AF).copy(alpha = 0.4f) else Color.White

    Box(
        modifier = Modifier
            .clickable { onClick() }
            .clip(RoundedCornerShape(12.dp))
            .then(
                if (day.isSelected) Modifier
                    .border(1.dp, Color(0xFF423C3A), RoundedCornerShape(16.dp))
                    .background(Color(0xFF171312))
                else Modifier
            )
            .padding(vertical = 12.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = day.day, color = textColor, style = captionSmallLeftStyle().copy(fontWeight = FontWeight.Bold, textAlign = TextAlign.Center))
            Text(text = day.date, color = textColor, style = bodySmallLeftStyle().copy(fontWeight = FontWeight.Bold, fontSize = 16.sp, textAlign = TextAlign.Center))
            Text(text = "Nov", color = subTextColor, style = captionXSmallLeftStyle().copy(textAlign = TextAlign.Center))
            Spacer(modifier = Modifier.height(8.dp))
            if (day.isCompleted) {
                Image(
                    painter = painterResource(id = R.drawable.check_icon),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color(0xFFAECFA7))
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(CircleShape)
                        .background(if (day.isSelected) Color(0xFF423C3A) else Color(0x1AFFFFFF))
                )
            }
        }
    }
}

