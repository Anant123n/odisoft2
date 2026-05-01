package com.example.medidation.ui.screens.custommeditation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medidation.ui.bigSubtitleCenteredStyle
import com.example.medidation.ui.screens.custommeditation.Accent
import com.example.medidation.ui.screens.custommeditation.AccentText

@Composable
internal fun BeginMeditationButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 28.dp, bottom = 32.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Accent)
            .padding(vertical = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Begin Meditation",
            color = AccentText,
            style = bigSubtitleCenteredStyle().copy(fontSize = 17.sp)
        )
    }
}
