package com.example.design1.ui.screens.podcast.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.design1.ui.bigSubtitleLeftStyle
import com.example.design1.ui.bodySmallLeftStyle
import com.example.design1.ui.captionSmallLeftStyle

@Composable
internal fun HistoryCard(
    date: String,
    title: String,
    duration: String,
    bgRes: Int,
    rightActionRes: Int,
    playActionRes: Int,
    progressRatio: Float
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF423C3A))
    ) {
        Box(modifier = Modifier.fillMaxWidth().height(190.dp)) {
            Image(
                painter = painterResource(id = bgRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Brush.verticalGradient(listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f))))
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(date, color = Color(0xFFA29C9A), style = captionSmallLeftStyle())
                Spacer(modifier = Modifier.height(4.dp))
                Text(title, color = Color(0xFFF2EBE9), style = bigSubtitleLeftStyle())
                Spacer(modifier = Modifier.height(4.dp))
                Text(duration, color = Color(0xFFB6B0AF), style = bodySmallLeftStyle())
            }
            Spacer(modifier = Modifier.width(12.dp))
            Image(painter = painterResource(id = rightActionRes), contentDescription = null, modifier = Modifier.size(36.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Image(painter = painterResource(id = playActionRes), contentDescription = null, modifier = Modifier.size(36.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 6.dp, bottom = 6.dp)
                .height(4.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0x1AFFFFFF))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progressRatio)
                    .height(4.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFFE6847))
            )
        }
    }
}

