package com.example.design1.ui.screens.voice.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design1.ui.bigSubtitleLeftStyle
import com.example.design1.ui.smallTitleStyle

@Composable
internal fun VoiceMessage(
    sender: String,
    text: String,
    avatarRes: Int,
    highlightText: String? = null
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Image(
            painter = painterResource(id = avatarRes),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Transparent)
                .padding(horizontal = 12.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    sender,
                    color = Color(0xFFF2EBE9).copy(alpha = 0.3f),
                    style = bigSubtitleLeftStyle().copy(fontSize = 17.sp)
                )
                
                val annotatedText = buildAnnotatedString {
                    if (highlightText != null && text.contains(highlightText)) {
                        val parts = text.split(highlightText)
                        withStyle(style = SpanStyle(color = Color(0xFFFE937B))) {
                            append(highlightText)
                        }
                        append(parts.getOrElse(1) { "" })
                    } else {
                        append(text)
                    }
                }
                
                Text(
                    text = annotatedText,
                    color = Color(0xFFF2EBE9),
                    style = smallTitleStyle().copy(fontSize = 20.sp, lineHeight = 26.sp)
                )
            }
        }
    }
}
