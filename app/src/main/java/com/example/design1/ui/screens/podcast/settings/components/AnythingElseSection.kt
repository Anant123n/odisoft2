package com.example.design1.ui.screens.podcast.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design1.ui.bigSubtitleCenteredStyle
import com.example.design1.ui.bodyMediumLeftStyle
import com.example.design1.ui.bodySmallCenteredStyle

@Composable
internal fun AnythingElseSection(
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                "Anything Else?",
                color = Color(0xFFF2EBE9),
                style = bigSubtitleCenteredStyle()
            )
            Text(
                "Optionally write down anything you would like to highlight in podcasts, focus on, or exclude.",
                color = Color(0xFFB6B0AF),
                style = bodySmallCenteredStyle()
            )
        }

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = bodyMediumLeftStyle().copy(color = Color(0xFFF2EBE9)),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0x1AFFFFFF))
                .padding(horizontal = 16.dp, vertical = 12.dp),
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        "Write anything...",
                        color = Color(0xFFB6B0AF),
                        style = bodyMediumLeftStyle().copy(
                            fontWeight = FontWeight.Normal,
                            lineHeight = 29.sp,
                            letterSpacing = 0.32.sp
                        )
                    )
                }
                innerTextField()
            }
        )
    }
}
