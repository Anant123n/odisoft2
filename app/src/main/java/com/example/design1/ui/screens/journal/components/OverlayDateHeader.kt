package com.example.design1.ui.screens.journal.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.example.design1.ui.bigSubtitleLeftStyle
import com.example.design1.ui.smallSubtitleLeftStyle

@Composable
internal fun OverlayDateHeader(showMoodIcon: Boolean = true) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showMoodIcon) {
            MoodIcon()
            Spacer(modifier = Modifier.width(8.dp))
        }
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                "Tuesday",
                color = Color(0xFFF2EBE9).copy(alpha = 0.8f),
                style = bigSubtitleLeftStyle()
            )
            Text(
                "3 November",
                color = Color(0xFFB6B0AF).copy(alpha = 0.8f),
                style = smallSubtitleLeftStyle()
            )
        }
    }
}

@Composable
private fun MoodIcon() {
    androidx.compose.foundation.layout.Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(Color(0xFF2F244C))
            .padding(3.dp),
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(Color(0xFFEFA063)),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val eyeY = size.height * 0.38f
                val leftEyeX = size.width * 0.38f
                val rightEyeX = size.width * 0.62f
                val mouthY = size.height * 0.66f

                drawLine(Color(0xB3000000), Offset(leftEyeX - 3f, eyeY - 2f), Offset(leftEyeX + 3f, eyeY + 2f), 2.2f, StrokeCap.Round)
                drawLine(Color(0xB3000000), Offset(leftEyeX + 3f, eyeY - 2f), Offset(leftEyeX - 3f, eyeY + 2f), 2.2f, StrokeCap.Round)
                drawLine(Color(0xB3000000), Offset(rightEyeX - 3f, eyeY - 2f), Offset(rightEyeX + 3f, eyeY + 2f), 2.2f, StrokeCap.Round)
                drawLine(Color(0xB3000000), Offset(rightEyeX + 3f, eyeY - 2f), Offset(rightEyeX - 3f, eyeY + 2f), 2.2f, StrokeCap.Round)
                drawLine(Color(0xB3000000), Offset(size.width * 0.35f, mouthY), Offset(size.width * 0.65f, mouthY), 2.4f, StrokeCap.Round)
            }
        }
    }
}

