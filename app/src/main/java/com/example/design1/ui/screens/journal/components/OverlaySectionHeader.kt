package com.example.design1.ui.screens.journal.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.design1.ui.bigSubtitleLeftStyle
import com.example.design1.ui.smallSubtitleLeftStyle

@Composable
internal fun OverlaySectionHeader(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, color = Color(0xCCF2EBE9), style = bigSubtitleLeftStyle())
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0x1AFFFFFF))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Add", color = Color(0xFFF2EBE9), style = smallSubtitleLeftStyle())
        }
    }
}

